package com.ruoyi.generator.domain;

import javax.validation.constraints.NotBlank;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.StringUtils;

/**
 * 代码生成业务字段表 gen_table_column
 *
 * @author ruoyi
 */
public class GenTableColumn extends BaseEntity
{
    /** 序列号 */
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long columnId;

    /** 归属表编号 */
    private Long tableId;

    /** 列名称 */
    private String columnName;

    /** 列描述 */
    private String columnComment;

    /** 列类型 */
    private String columnType;

    /** JAVA类型 */
    private String javaType;

    /** JAVA字段名 */
    @NotBlank(message = "Java属性不能为空")
    private String javaField;

    /** 是否主键（1是） */
    private String isPk;

    /** 是否自增（1是） */
    private String isIncrement;

    /** 是否必填（1是） */
    private String isRequired;

    /** 是否为插入字段（1是） */
    private String isInsert;

    /** 是否编辑字段（1是） */
    private String isEdit;

    /** 是否列表字段（1是） */
    private String isList;

    /** 是否查询字段（1是） */
    private String isQuery;

    /** 查询方式（EQ等于、NE不等于、GT大于、LT小于、LIKE模糊、BETWEEN范围） */
    private String queryType;

    /** 显示类型（input文本框、textarea文本域、select下拉框、checkbox复选框、radio单选框、datetime日期控件、image图片上传控件、upload文件上传控件、editor富文本控件） */
    private String htmlType;

    /** 字典类型 */
    private String dictType;

    /** 排序 */
    private Integer sort;

    /**
     * Sets column id.
     *
     * @param columnId the column id
     */
    public void setColumnId(Long columnId)
    {
        this.columnId = columnId;
    }

    /**
     * Gets column id.
     *
     * @return the column id
     */
    public Long getColumnId()
    {
        return columnId;
    }

    /**
     * Sets table id.
     *
     * @param tableId the table id
     */
    public void setTableId(Long tableId)
    {
        this.tableId = tableId;
    }

    /**
     * Gets table id.
     *
     * @return the table id
     */
    public Long getTableId()
    {
        return tableId;
    }

    /**
     * Sets column name.
     *
     * @param columnName the column name
     */
    public void setColumnName(String columnName)
    {
        this.columnName = columnName;
    }

    /**
     * Gets column name.
     *
     * @return the column name
     */
    public String getColumnName()
    {
        return columnName;
    }

    /**
     * Sets column comment.
     *
     * @param columnComment the column comment
     */
    public void setColumnComment(String columnComment)
    {
        this.columnComment = columnComment;
    }

    /**
     * Gets column comment.
     *
     * @return the column comment
     */
    public String getColumnComment()
    {
        return columnComment;
    }

    /**
     * Sets column type.
     *
     * @param columnType the column type
     */
    public void setColumnType(String columnType)
    {
        this.columnType = columnType;
    }

    /**
     * Gets column type.
     *
     * @return the column type
     */
    public String getColumnType()
    {
        return columnType;
    }

    /**
     * Sets java type.
     *
     * @param javaType the java type
     */
    public void setJavaType(String javaType)
    {
        this.javaType = javaType;
    }

    /**
     * Gets java type.
     *
     * @return the java type
     */
    public String getJavaType()
    {
        return javaType;
    }

    /**
     * Sets java field.
     *
     * @param javaField the java field
     */
    public void setJavaField(String javaField)
    {
        this.javaField = javaField;
    }

    /**
     * Gets java field.
     *
     * @return the java field
     */
    public String getJavaField()
    {
        return javaField;
    }

    /**
     * Gets cap java field.
     *
     * @return the cap java field
     */
    public String getCapJavaField()
    {
        return StringUtils.capitalize(javaField);
    }

    /**
     * Sets is pk.
     *
     * @param isPk the is pk
     */
    public void setIsPk(String isPk)
    {
        this.isPk = isPk;
    }

    /**
     * Gets is pk.
     *
     * @return the is pk
     */
    public String getIsPk()
    {
        return isPk;
    }

    /**
     * Is pk boolean.
     *
     * @return the boolean
     */
    public boolean isPk()
    {
        return isPk(this.isPk);
    }

    /**
     * Is pk boolean.
     *
     * @param isPk the is pk
     * @return the boolean
     */
    public boolean isPk(String isPk)
    {
        return isPk != null && StringUtils.equals("1", isPk);
    }

    /**
     * Gets is increment.
     *
     * @return the is increment
     */
    public String getIsIncrement()
    {
        return isIncrement;
    }

    /**
     * Sets is increment.
     *
     * @param isIncrement the is increment
     */
    public void setIsIncrement(String isIncrement)
    {
        this.isIncrement = isIncrement;
    }

    /**
     * Is increment boolean.
     *
     * @return the boolean
     */
    public boolean isIncrement()
    {
        return isIncrement(this.isIncrement);
    }

    /**
     * Is increment boolean.
     *
     * @param isIncrement the is increment
     * @return the boolean
     */
    public boolean isIncrement(String isIncrement)
    {
        return isIncrement != null && StringUtils.equals("1", isIncrement);
    }

    /**
     * Sets is required.
     *
     * @param isRequired the is required
     */
    public void setIsRequired(String isRequired)
    {
        this.isRequired = isRequired;
    }

    /**
     * Gets is required.
     *
     * @return the is required
     */
    public String getIsRequired()
    {
        return isRequired;
    }

    /**
     * Is required boolean.
     *
     * @return the boolean
     */
    public boolean isRequired()
    {
        return isRequired(this.isRequired);
    }

    /**
     * Is required boolean.
     *
     * @param isRequired the is required
     * @return the boolean
     */
    public boolean isRequired(String isRequired)
    {
        return isRequired != null && StringUtils.equals("1", isRequired);
    }

    /**
     * Sets is insert.
     *
     * @param isInsert the is insert
     */
    public void setIsInsert(String isInsert)
    {
        this.isInsert = isInsert;
    }

    /**
     * Gets is insert.
     *
     * @return the is insert
     */
    public String getIsInsert()
    {
        return isInsert;
    }

    /**
     * Is insert boolean.
     *
     * @return the boolean
     */
    public boolean isInsert()
    {
        return isInsert(this.isInsert);
    }

    /**
     * Is insert boolean.
     *
     * @param isInsert the is insert
     * @return the boolean
     */
    public boolean isInsert(String isInsert)
    {
        return isInsert != null && StringUtils.equals("1", isInsert);
    }

    /**
     * Sets is edit.
     *
     * @param isEdit the is edit
     */
    public void setIsEdit(String isEdit)
    {
        this.isEdit = isEdit;
    }

    /**
     * Gets is edit.
     *
     * @return the is edit
     */
    public String getIsEdit()
    {
        return isEdit;
    }

    /**
     * Is edit boolean.
     *
     * @return the boolean
     */
    public boolean isEdit()
    {
        return isInsert(this.isEdit);
    }

    /**
     * Is edit boolean.
     *
     * @param isEdit the is edit
     * @return the boolean
     */
    public boolean isEdit(String isEdit)
    {
        return isEdit != null && StringUtils.equals("1", isEdit);
    }

    /**
     * Sets is list.
     *
     * @param isList the is list
     */
    public void setIsList(String isList)
    {
        this.isList = isList;
    }

    /**
     * Gets is list.
     *
     * @return the is list
     */
    public String getIsList()
    {
        return isList;
    }

    /**
     * Is list boolean.
     *
     * @return the boolean
     */
    public boolean isList()
    {
        return isList(this.isList);
    }

    /**
     * Is list boolean.
     *
     * @param isList the is list
     * @return the boolean
     */
    public boolean isList(String isList)
    {
        return isList != null && StringUtils.equals("1", isList);
    }

    /**
     * Sets is query.
     *
     * @param isQuery the is query
     */
    public void setIsQuery(String isQuery)
    {
        this.isQuery = isQuery;
    }

    /**
     * Gets is query.
     *
     * @return the is query
     */
    public String getIsQuery()
    {
        return isQuery;
    }

    /**
     * Is query boolean.
     *
     * @return the boolean
     */
    public boolean isQuery()
    {
        return isQuery(this.isQuery);
    }

    /**
     * Is query boolean.
     *
     * @param isQuery the is query
     * @return the boolean
     */
    public boolean isQuery(String isQuery)
    {
        return isQuery != null && StringUtils.equals("1", isQuery);
    }

    /**
     * Sets query type.
     *
     * @param queryType the query type
     */
    public void setQueryType(String queryType)
    {
        this.queryType = queryType;
    }

    /**
     * Gets query type.
     *
     * @return the query type
     */
    public String getQueryType()
    {
        return queryType;
    }

    /**
     * Gets html type.
     *
     * @return the html type
     */
    public String getHtmlType()
    {
        return htmlType;
    }

    /**
     * Sets html type.
     *
     * @param htmlType the html type
     */
    public void setHtmlType(String htmlType)
    {
        this.htmlType = htmlType;
    }

    /**
     * Sets dict type.
     *
     * @param dictType the dict type
     */
    public void setDictType(String dictType)
    {
        this.dictType = dictType;
    }

    /**
     * Gets dict type.
     *
     * @return the dict type
     */
    public String getDictType()
    {
        return dictType;
    }

    /**
     * Sets sort.
     *
     * @param sort the sort
     */
    public void setSort(Integer sort)
    {
        this.sort = sort;
    }

    /**
     * Gets sort.
     *
     * @return the sort
     */
    public Integer getSort()
    {
        return sort;
    }

    /**
     * Is super column boolean.
     *
     * @return the boolean
     */
    public boolean isSuperColumn()
    {
        return isSuperColumn(this.javaField);
    }

    /**
     * Is super column boolean.
     *
     * @param javaField the java field
     * @return the boolean
     */
    public static boolean isSuperColumn(String javaField)
    {
        return StringUtils.equalsAnyIgnoreCase(javaField,
                // BaseEntity
                "createBy", "createTime", "updateBy", "updateTime", "remark",
                // TreeEntity
                "parentName", "parentId", "orderNum", "ancestors");
    }

    /**
     * Is usable column boolean.
     *
     * @return the boolean
     */
    public boolean isUsableColumn()
    {
        return isUsableColumn(javaField);
    }

    /**
     * Is usable column boolean.
     *
     * @param javaField the java field
     * @return the boolean
     */
    public static boolean isUsableColumn(String javaField)
    {
        // isSuperColumn()中的名单用于避免生成多余Domain属性，若某些属性在生成页面时需要用到不能忽略，则放在此处白名单
        return StringUtils.equalsAnyIgnoreCase(javaField, "parentId", "orderNum", "remark");
    }

    /**
     * Read converter exp string.
     *
     * @return the string
     */
    public String readConverterExp()
    {
        String remarks = StringUtils.substringBetween(this.columnComment, "（", "）");
        StringBuffer sb = new StringBuffer();
        if (StringUtils.isNotEmpty(remarks))
        {
            for (String value : remarks.split(" "))
            {
                if (StringUtils.isNotEmpty(value))
                {
                    Object startStr = value.subSequence(0, 1);
                    String endStr = value.substring(1);
                    sb.append("").append(startStr).append("=").append(endStr).append(",");
                }
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }
        else
        {
            return this.columnComment;
        }
    }
}
