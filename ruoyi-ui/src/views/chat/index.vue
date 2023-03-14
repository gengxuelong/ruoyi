<template>
  <div style="padding: 10px; margin-bottom: 50px">
    <el-row>
      <el-col :span="4">
        <div style="position: fixed">
          <div style="position: relative;left: 0;top: 30px">
            用户昵称：
          </div>
          <div v-if="user.username===''" style="position: relative;left: 100px">
            <el-input v-model="inputUsername" clearable :autofocus="true" style="position: fixed; width: 130px;"/>
            <div style="color: red;position: fixed;margin-top: 50px;margin-left: -100px">
            当前状态:未连接
           </div>
          </div>
          <span v-else style="position: relative;left: 80px">
            <span style="position: fixed;margin-top: 10px;margin-left: 18px">
              {{ userNameForShow }}
            </span>
            <span style="color: #43e143;position: fixed;margin-top: 50px;margin-left: -80px">
            当前状态:已连接
           </span>
          </span>
          <span v-if="user.username===''" style="position: relative;left: 150px">
            <el-button type="primary" size="mini" @click="linking"
                       style="position:relative;left: 100px;margin-top: 4px">连接</el-button>
          </span>
          <span v-else style="position: relative;left: 150px">
            <el-button type="primary" size="mini" @click="updateUsername"
                       style="position:relative;left: 100px;margin-top: 4px">修改</el-button>
          </span>
        </div>
        <el-card style="width: 300px; height: 300px; color: #333;margin-top: 100px">
          <div style="padding-bottom: 10px; border-bottom: 1px solid #ccc">
            在线用户
            <span style="font-size: 12px">
            （点击聊天气泡开始聊天）
          </span>
          </div>
          <div style="padding: 10px 0">
            <span>世界聊天</span>
            <i class="el-icon-chat-dot-round" style="margin-left: 10px; font-size: 16px; cursor: pointer"
               @click="intoWorld()"></i>
            <span style="font-size: 12px;color: limegreen; margin-left: 5px"
                  v-if="isInWorld">world-chat click again to leave</span>
          </div>
          <div style="padding: 10px 0" v-for="user in users" :key="user.username">
            <span class="text-username">{{ user.username }}</span>
            <i class="el-icon-chat-dot-round" style="margin-left: 10px; font-size: 16px; cursor: pointer"
               @click="switchFriend(user.username)"></i>
            <i class="el-icon-bell" v-if="contains(requestUsers,user.username.trim())"
               style="margin-left: 10px; font-size: 16px;"></i>
            <span style="font-size: 12px;color: limegreen; margin-left: 5px"
                  v-if="user.username === chatUser&&isInWorld===false">chatting...</span>
          </div>
        </el-card>
        <i @click="openDialog" class="el-icon-setting"></i>
      </el-col>
      <el-col :span="20">
        <div style="width: 800px; margin: 0 auto; background-color: white;
                    border-radius: 5px; box-shadow: 0 0 10px #ccc">
          <div style="text-align: center; line-height: 50px;">
            Web聊天室（{{ isInWorld ? '世界聊天' : chatUser }}）
          </div>
          <div id="main" style="height: 350px; overflow:auto; border-top: 1px solid #ccc" v-html="content"></div>
          <div style="height: 200px">
            <textarea v-if="enableEnter&&enableCtrlEnter" v-model="text" style="margin: 0" @keydown.enter.prevent="send" @keydown.ctrl.enter="send"></textarea>
            <textarea v-if="enableEnter&&!enableCtrlEnter" v-model="text" style="margin: 0" @keydown.enter.prevent="send"></textarea>
            <textarea v-if="!enableEnter&&enableCtrlEnter" v-model="text" style="margin: 0" @keydown.ctrl.enter="send"></textarea>
            <textarea v-if="!enableEnter&&!enableCtrlEnter" v-model="text" style="margin: 0"></textarea>
            <div style="padding: 0;margin: 0">
              <button class="send-btn" @click="send" style="width: 100%">发送</button>
            </div>
          </div>
        </div>
      </el-col>
    </el-row>
    <el-dialog title="设置" :visible.sync="open" width="600px" append-to-body>
      <el-checkbox v-model="enableEnter">按enter发送</el-checkbox>
      <el-checkbox v-model="enableCtrlEnter">按ctrl+enter发送</el-checkbox>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="closeDialog">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import axios from 'axios';
axios.defaults.baseURL = 'http://localhost:8080';
let socket;
export default {

  /*
  该vue组件的名称
   */
  name: "Im",

  /*
  vue 的变量数据存放地
   */
  data() {
    return {
      //当前用户
      user: {
        username: ''
      },
      //是否已经连接服务器
      isLinked: false,
      //是否已经在世界聊天大厅
      isInWorld: false,
      //连接时输入的用户名
      inputUsername: "",
      //在线用户列表
      users: [],
      //交谈的对象
      chatUser: '',
      //发送的信息文本
      text: "",
      //发送的信息内容
      messages: [],
      // 框内显示的内容
      content: '',
      //请求聊天的用户的用户名列表
      requestUsers:[],
      //设置对话框是否打开
      open:false,
      //按enter键发送
      enableEnter:true,
      //按ctrl+enter键发送
      enableCtrlEnter:false,
    }
  },

  /*
  计算方法
   */
  computed:{

    /*
    用于监控用户名字的长度，当用户名长度大于8，进行截取
     */
    userNameForShow(){
      if(this.user.username.length>=8){
        return this.user.username.slice(0,8)+'..'
      }else {
        return this.user.username
      }
    }
  },


  /*
  常规方法
   */
  methods: {

    /*
    当点击进入世界聊天大厅后的操作
     */
    intoWorld() {
      console.log('intoWorld')
      /*
      当自己已经连接后端服务器时
       */
      if (this.isLinked) {
        /*
        当点击进入前没在世界大厅时
         */
        if (this.isInWorld === false) {
          /*
          如果点击进入前自己正在和其他用户聊天，则通知他自己已断开通话
           */
          if(this.chatUser!==''){
            this.alertChatUserWhenLeave(this.chatUser)
          }
          this.isInWorld = true;
          this.chatUser = '';
          /*
          从后端请求聊天大厅的所有聊天记录
           */
          axios("/chat/hello").then(res => {
            this.content = ''
            res.data.forEach(element => {
              console.log(element.username, element.text)
              if (element.username === this.user.username) {
                this.createContent(null, element.username, element.text)
              } else {
                this.createContent(element.username, null, element.text)
              }
            });
            this.updateScroll();
          })
          // this.updateScroll();此函数必须和dom变化紧挨着
          /*
          开启定时器，没两秒中从后端获取一次最新数据
           */
          this.Interval = setInterval(() => {
            axios("/chat/hello").then(res => {
              this.content = '';
              res.data.forEach(element => {
                console.log(element.username, element.text)
                if (element.username === this.user.username) {
                  this.createContent(null, element.username, element.text)
                } else {
                  this.createContent(element.username, null, element.text)
                }
              });
              this.updateScroll();
            })
          }, 2000);
        }
        /*
        当进入前自己已经在世界大厅聊天时
         */
        else {
          this.isInWorld = false;
          this.content = '';
          clearInterval(this.Interval);
        }
      }
      /*
      当自己没有连接服务器时，给予文字提示
       */
      else {
        window.alert("请先连接，连接后才能进入世界大厅哟")
      }
    },

    /*
    改变聊天对象时的操作
     */
    switchFriend(username) {
      if(username===this.chatUser){
        window.alert("已经和她连接了哟")
        return;
      }
      if(this.chatUser!==''){
        this.alertChatUserWhenLeave(this.chatUser)
      }
      if (this.isInWorld === false) {
        console.log('switchFriend')
        this.chatUser = username;
        this.content = '';
      } else {
        this.isInWorld = false;
        this.content = '';
        clearInterval(this.Interval);
        console.log('switchFriend')
        this.chatUser = username;
        this.content = '';
      }
      let message = {to: this.chatUser,function:'link'}
      socket.send(JSON.stringify(message));
    },

    /*
    实现发送按钮按下后的具体操作
     */
    send() {
      /*
      当用户未连接服务器的时候，给予文字提醒
       */
      if (this.user.username === '') {
        this.$message({type: 'warning', message: "未连接哟，请连接"})
      }
      /*
      当连接到服务器后，进行如下操作
       */
      else {
        /*
        如果是私聊发送功能，进行如下操作
         */
        if (this.isInWorld === false) {
          if (!this.chatUser) {
            this.$message({type: 'warning', message: "请选择聊天对象"})
            return;
          }
          if (!this.text) {
            this.$message({type: 'warning', message: "请输入内容"})
          } else {
            if (typeof (WebSocket) == "undefined") {
              console.log("您的浏览器不支持WebSocket");
            } else {
              console.log("您的浏览器支持WebSocket");
              /*
                组装待发送的消息 json
                例如： {"from": "zhang", "to": "admin", "text": "聊天文本"}
               */
              let message = {from: this.user.username, to: this.chatUser, text: this.text}
              socket.send(JSON.stringify(message));  // 将组装好的json发送给服务端，由服务端进行转发
              this.messages.push({user: this.user.username, text: this.text})
              // 构建消息内容，本人消息
              this.createContent(null, this.user.username, this.text)
              this.text = '';
              this.updateScroll();
            }
          }
        }
        /*
        如果是世界大厅发送功能，进行如下操作
         */
        else {
          // 构建消息内容，本人消息
          this.createContent(null, this.user.username, this.text)
          let username = this.user.username;
          let text = this.text;
          /*
          像后端发送axios请求，将自己发送的聊天信息保存到后端数据库
           */
          axios.post("/chat/add", {
            "username": username,
            "text": text,
          }).then(res => {
            console.log(res.data)
          }).catch(e => {
          })
          this.text = '';
          this.updateScroll();
        }
      }
    },

    /*
    这个方法是用来将 json的聊天消息数据转换成 html的。
     */
    createContent(remoteUser, nowUser, text) {
      let html
      /*
       如果存在参数 nowUser， 表示是否显示当前用户发送的聊天消息，绿色气泡
       */
      if (nowUser) {
        html = "<div class=\"el-row\" style=\"padding: 5px 0\">\n" +
          "  <div class=\"el-col el-col-22\" style=\"text-align: right;\">\n" +
          "  <div style=\"font-size:15px;color:black;background-color:white; \" class=\"left\">" + nowUser + "</div>  <div class=\"tip left\">" + text + "</div>\n" +
          "  </div>\n" +
          "  <div class=\"el-col el-col-2\">\n" +
          "  <span class=\"el-avatar el-avatar--circle\" style=\"height: 40px; width: 40px; line-height: 40px;\">\n" +
          "    <img src=\"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png\" style=\"object-fit: cover;\">\n" +
          "  </span>\n" +
          "  </div>\n" +
          "</div>";
      }
      /*
      如果存在参数remoteUser，表示远程用户聊天消息，蓝色的气泡
       */
      else if (remoteUser) {
        html = "<div class=\"el-row\" style=\"padding: 5px 0\">\n" +
          "  <div class=\"el-col el-col-2\" style=\"text-align: right\">\n" +
          "  <span class=\"el-avatar el-avatar--circle\" style=\"height: 40px; width: 40px; line-height: 40px;\">\n" +
          "    <img src=\"https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png\" style=\"object-fit: cover;\">\n" +
          "  </span>\n" +
          "  </div>\n" +
          "  <div class=\"el-col el-col-22\" style=\"text-align: left;\">\n" +
          "    <div style=\"font-size:15px;background-color:white;\" class=\"right\">" + remoteUser + "</div><div class=\"tip right\">" + text + "</div>\n" +
          "  </div>\n" +
          "</div>";
      }
      this.content += html;
    },

    /*
    用来连接后socket端服务器
     */
    linking() {
      console.log("linking")
      /*
      如果已经连接
       */
      if (this.user.username !== '') {
        window.alert("您已经连接了亲，您的用户名是: " + this.user.username)
      }
      /*
      没有连接，且输入了用户名，进行连接操作
       */
      else if (this.inputUsername !== '') {
        this.user.username = this.inputUsername;
        this.isLinked = true;
        let _this = this;
        /*
        判断浏览器是否支持webSocket
         */
        if (typeof (WebSocket) == "undefined") {
          console.log("您的浏览器不支持WebSocket");
        } else {
          console.log("您的浏览器支持WebSocket");
          let socketUrl = "ws://localhost:8080/chat/myServer/" + this.user.username;
          if (socket != null) {
            socket.close();
            socket = null;
          }
          /*
          开启一个websocket服务
           */
          socket = new WebSocket(socketUrl);
          this.handleSocket(socket, _this);
        }
      }
      /*
      没输入用户名的情况
       */
      else {
        window.alert("请输入用户名呀亲，不输入是没法连接的哟")
      }
    },

    /*
    更新用户的名称
     */
    updateUsername() {
      this.user.username = ''
    },

    /*
    连接到后端websocket服务器后，处理socket的一些操作
     */
    handleSocket(socket, _this) {
      /*
      打开事件
       */
      socket.onopen = function () {
        console.log("websocket已打开");
      };

      /*
      浏览器端收消息，获得从服务端发送过来的文本消息
       */
      socket.onmessage = function (msg) {
        console.log("收到数据====" + msg.data)
        // 对收到的json数据进行解析，
        // //类似这样的： {"users": [{"username": "zhang"},{ "username": "admin"}]}
        let data = JSON.parse(msg.data)
        console.log(data)
        /*
          如果存在该users字段，说明这时公共消息，则如下处理，
          获取当前连接的所有用户信息，并且使用vue过滤器将本人排除在在线用户展示列表之外，
          使得自己不会出现在自己的聊天列表里
           */
        if (data.users) {
          _this.users = data.users.filter(user => user.username.trim() !== _this.user.username.trim())
        }
        /*
        如果不存在users字段，且不存在text字段时，
        则说明信息为控制类信息，做一下处理
         */
        else if(data.text==null){
          let tip = data.function;
          console.log("function:"+tip);
          let remoteFriend = data.from;
          /*
          当控制信息为leave时，
          说明之前想和自己通信的用户取消了和自己通信的请求
          做以下操作
           */
          if(tip==='leave'){
            _this.handleDisconnect(remoteFriend)
          }
          /*
          当控制信息为link时，
          说明有用户发起了想和自己通信的请求
          做以下操作
           */
          else if(tip==='link'){
            _this.handleRequest(remoteFriend)
          }
        }
        /*
          如果包含text字段，则说明是常规聊天信息
          形如：  {"from": "zhang", "text": "hello"}
        */
        else {
          if (data.from === _this.chatUser) {
            /*
            构建消息内容
             */
            _this.createContent(data.from, null, data.text)
          }
        }
      };

      /*
      关闭事件
       */
      socket.onclose = function () {
        console.log("websocket已关闭");
      };

      /*
      发生了错误事件
       */
      socket.onerror = function () {
        console.log("websocket发生了错误");
      }
    },

    /*
    当有远程客户发起和你通信请求时的具体操作，
    即对用户进行文字提醒，并将该远程用户放入本用户的请求列表，以供用户选择具体和谁通信
     */
    handleRequest(username){
      this.$message({
        message: "用户名为 "+username+" 的用户想和你通信",
        type: 'success'
      });
      this.requestUsers.push(username)
    },

    /*
    处理远程客户放弃和自己通信请求时的具体操作
    先对用户进行文字提醒，然后将该远程客户从请求列表中移除
     */
    handleDisconnect(username){
      this.$message({
        message: "用户名为 "+username+" 的用户断开了通信",
        type: 'warning'
      });
      for (let i = 0; i < this.requestUsers.length; i++) {
        if (this.requestUsers[i]===username){
          this.requestUsers.splice(i,1)
        }
      }
    },

    /*
    实现将滚动条自动滚动到最下方的作用
     */
    updateScroll() {
      this.$nextTick(() => {
        let container = this.$el.querySelector("#main");
        container.scrollTop = container.scrollHeight;
      })
    },

    /*
    动自己放弃对欲通信客户通信请求的时候，告知欲通信客户自己已经放弃
     */
    alertChatUserWhenLeave(chatUser){
      let message = {from: this.user.username, to: chatUser, function: 'leave'}
      // 将组装好的json发送给服务端，由服务端进行转发
      socket.send(JSON.stringify(message));
    },

    /*
   工具方法，判断一个数组arr中是否包含e元素
     */
    contains(arr,e){
      for (let i = 0; i < arr.length; i++) {
        if(arr[i].trim()===e) return true
      }
      return false
    },
    openDialog(){
      this.open=true
    },
    closeDialog() {
      this.open=false
    }
  }
}
</script>
<style>
.tip {
  color: white;
  text-align: center;
  border-radius: 10px;
  font-family: sans-serif;
  padding: 10px;
  width: auto;
  display: inline-block !important;
}

.right {
  background-color: deepskyblue;
}

.left {
  background-color: #66c213;
}

textarea {
  height: 160px;
  width: 100%;
  padding: 20px;
  margin: 0;
  font-size: 16px;
  font-family: "Times New Roman", Times, serif;
  border: none;
  border-top: 1px solid #ccc;
  outline: none;
  resize: none;
}

.send-btn {
  background: #d6e5e4;
  color: #000;
  outline: none;
  display: block;
  border: none;
  cursor: pointer;
  padding: 9px 38px;
  font-size: 14px;
  font-weight: bold;
  text-transform: uppercase;
  transition: 0.3s all;
  -webkit-transition: 0.3s all;
  -moz-transition: 0.3s all;
  -o-transition: 0.3s all;
  -ms-transition: 0.3s all;
}

.send-btn:hover {
  background: #62eade;
  color: #ffffff;
  transition: 0.3s all;
  -webkit-transition: 0.3s all;
  -moz-transition: 0.3s all;
  -o-transition: 0.3s all;
  -ms-transition: 0.3s all;
}
</style>
