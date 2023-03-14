<template>
<!--
  查询表单的展示
-->
  <el-form ref="basicInfoForm" :model="info" :rules="rules" label-width="150px">
    <el-row>
<!--   输入仓库名称   -->
      <el-col :span="12">
        <el-form-item label="表名称" prop="tableName">
          <el-input placeholder="请输入仓库名称" v-model="info.tableName" />
        </el-form-item>
      </el-col>
<!--   表描述   -->
      <el-col :span="12">
        <el-form-item label="表描述" prop="tableComment">
          <el-input placeholder="请输入" v-model="info.tableComment" />
        </el-form-item>
      </el-col>
<!--   实体类名称   -->
      <el-col :span="12">
        <el-form-item label="实体类名称" prop="className">
          <el-input placeholder="请输入" v-model="info.className" />
        </el-form-item>
      </el-col>
<!--      作者    -->
      <el-col :span="12">
        <el-form-item label="作者" prop="functionAuthor">
          <el-input placeholder="请输入" v-model="info.functionAuthor" />
        </el-form-item>
      </el-col>
<!--   备注   -->
      <el-col :span="24">
        <el-form-item label="备注" prop="remark">
          <el-input type="textarea" :rows="3" v-model="info.remark"></el-input>
        </el-form-item>
      </el-col>
    </el-row>
  </el-form>
</template>

<script>
/*
将此组件输出
 */
export default {
  /*
    让组件接收外部传来的数据，实现组件的复用
   */
  props: {
    /*
    一个参数的对象
     */
    info: {
      type: Object,
      default: null
    }
  },
  /*
  该组件的数据参数
   */
  data() {
    return {
      /*
      表单的提示信息
       */
      rules: {
        tableName: [
          { required: true, message: "请输入表名称", trigger: "blur" }
        ],
        tableComment: [
          { required: true, message: "请输入表描述", trigger: "blur" }
        ],
        className: [
          { required: true, message: "请输入实体类名称", trigger: "blur" }
        ],
        functionAuthor: [
          { required: true, message: "请输入作者", trigger: "blur" }
        ]
      }
    };
  }
};
</script>
