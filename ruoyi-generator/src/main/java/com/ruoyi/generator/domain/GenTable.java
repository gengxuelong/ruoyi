package com.ruoyi.generator.domain;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import org.apache.commons.lang3.ArrayUtils;
import com.ruoyi.common.constant.GenConstants;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.utils.StringUtils;

/**
 * 业务表 gen_table
 *
 * @author ruoyi
 */
public class GenTable extends BaseEntity
{
    /** 序列号id */
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long tableId;

    /** 表名称 */
    @NotBlank(message = "表名称不能为空")
    private String tableName;

    /** 表描述 */
    @NotBlank(message = "表描述不能为空")
    private String tableComment;

    /** 关联父表的表名 */
    private String subTableName;

    /** 本表关联父表的外键名 */
    private String subTableFkName;

    /** 实体类名称(首字母大写) */
    @NotBlank(message = "实体类名称不能为空")
    private String className;

    /** 使用的模板（crud单表操作 tree树表操作 sub主子表操作） */
    private String tplCategory;

    /** 生成包路径 */
    @NotBlank(message = "生成包路径不能为空")
    private String packageName;

    /** 生成模块名 */
    @NotBlank(message = "生成模块名不能为空")
    private String moduleName;

    /** 生成业务名 */
    @NotBlank(message = "生成业务名不能为空")
    private String businessName;

    /** 生成功能名 */
    @NotBlank(message = "生成功能名不能为空")
    private String functionName;

    /** 生成作者 */
    @NotBlank(message = "作者不能为空")
    private String functionAuthor;

    /** 生成代码方式（0zip压缩包 1自定义路径） */
    private String genType;

    /** 生成路径（不填默认项目路径） */
    private String genPath;

    /** 主键信息 */
    private GenTableColumn pkColumn;

    /** 子表信息 */
    private GenTable subTable;

    /** 表列信息 */
    @Valid
    private List<GenTableColumn> columns;

    /** 其它生成选项 */
    private String options;

    /** 树编码字段 */
    private String treeCode;

    /** 树父编码字段 */
    private String treeParentCode;

    /** 树名称字段 */
    private String treeName;

    /** 上级菜单ID字段 */
    private String parentMenuId;

    /** 上级菜单名称字段 */
    private String parentMenuName;

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
     * Sets table id.
     *
     * @param tableId the table id
     */
    public void setTableId(Long tableId)
    {
        this.tableId = tableId;
    }

    /**
     * Gets table name.
     *
     * @return the table name
     */
    public String getTableName()
    {
        return tableName;
    }

    /**
     * Sets table name.
     *
     * @param tableName the table name
     */
    public void setTableName(String tableName)
    {
        this.tableName = tableName;
    }

    /**
     * Gets table comment.
     *
     * @return the table comment
     */
    public String getTableComment()
    {
        return tableComment;
    }

    /**
     * Sets table comment.
     *
     * @param tableComment the table comment
     */
    public void setTableComment(String tableComment)
    {
        this.tableComment = tableComment;
    }

    /**
     * Gets sub table name.
     *
     * @return the sub table name
     */
    public String getSubTableName()
    {
        return subTableName;
    }

    /**
     * Sets sub table name.
     *
     * @param subTableName the sub table name
     */
    public void setSubTableName(String subTableName)
    {
        this.subTableName = subTableName;
    }

    /**
     * Gets sub table fk name.
     *
     * @return the sub table fk name
     */
    public String getSubTableFkName()
    {
        return subTableFkName;
    }

    /**
     * Sets sub table fk name.
     *
     * @param subTableFkName the sub table fk name
     */
    public void setSubTableFkName(String subTableFkName)
    {
        this.subTableFkName = subTableFkName;
    }

    /**
     * Gets class name.
     *
     * @return the class name
     */
    public String getClassName()
    {
        return className;
    }

    /**
     * Sets class name.
     *
     * @param className the class name
     */
    public void setClassName(String className)
    {
        this.className = className;
    }

    /**
     * Gets tpl category.
     *
     * @return the tpl category
     */
    public String getTplCategory()
    {
        return tplCategory;
    }

    /**
     * Sets tpl category.
     *
     * @param tplCategory the tpl category
     */
    public void setTplCategory(String tplCategory)
    {
        this.tplCategory = tplCategory;
    }

    /**
     * Gets package name.
     *
     * @return the package name
     */
    public String getPackageName()
    {
        return packageName;
    }

    /**
     * Sets package name.
     *
     * @param packageName the package name
     */
    public void setPackageName(String packageName)
    {
        this.packageName = packageName;
    }

    /**
     * Gets module name.
     *
     * @return the module name
     */
    public String getModuleName()
    {
        return moduleName;
    }

    /**
     * Sets module name.
     *
     * @param moduleName the module name
     */
    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    /**
     * Gets business name.
     *
     * @return the business name
     */
    public String getBusinessName()
    {
        return businessName;
    }

    /**
     * Sets business name.
     *
     * @param businessName the business name
     */
    public void setBusinessName(String businessName)
    {
        this.businessName = businessName;
    }

    /**
     * Gets function name.
     *
     * @return the function name
     */
    public String getFunctionName()
    {
        return functionName;
    }

    /**
     * Sets function name.
     *
     * @param functionName the function name
     */
    public void setFunctionName(String functionName)
    {
        this.functionName = functionName;
    }

    /**
     * Gets function author.
     *
     * @return the function author
     */
    public String getFunctionAuthor()
    {
        return functionAuthor;
    }

    /**
     * Sets function author.
     *
     * @param functionAuthor the function author
     */
    public void setFunctionAuthor(String functionAuthor)
    {
        this.functionAuthor = functionAuthor;
    }

    /**
     * Gets gen type.
     *
     * @return the gen type
     */
    public String getGenType()
    {
        return genType;
    }

    /**
     * Sets gen type.
     *
     * @param genType the gen type
     */
    public void setGenType(String genType)
    {
        this.genType = genType;
    }

    /**
     * Gets gen path.
     *
     * @return the gen path
     */
    public String getGenPath()
    {
        return genPath;
    }

    /**
     * Sets gen path.
     *
     * @param genPath the gen path
     */
    public void setGenPath(String genPath)
    {
        this.genPath = genPath;
    }

    /**
     * Gets pk column.
     *
     * @return the pk column
     */
    public GenTableColumn getPkColumn()
    {
        return pkColumn;
    }

    /**
     * Sets pk column.
     *
     * @param pkColumn the pk column
     */
    public void setPkColumn(GenTableColumn pkColumn)
    {
        this.pkColumn = pkColumn;
    }

    /**
     * Gets sub table.
     *
     * @return the sub table
     */
    public GenTable getSubTable()
    {
        return subTable;
    }

    /**
     * Sets sub table.
     *
     * @param subTable the sub table
     */
    public void setSubTable(GenTable subTable)
    {
        this.subTable = subTable;
    }

    /**
     * Gets columns.
     *
     * @return the columns
     */
    public List<GenTableColumn> getColumns()
    {
        return columns;
    }

    /**
     * Sets columns.
     *
     * @param columns the columns
     */
    public void setColumns(List<GenTableColumn> columns)
    {
        this.columns = columns;
    }

    /**
     * Gets options.
     *
     * @return the options
     */
    public String getOptions()
    {
        return options;
    }

    /**
     * Sets options.
     *
     * @param options the options
     */
    public void setOptions(String options)
    {
        this.options = options;
    }

    /**
     * Gets tree code.
     *
     * @return the tree code
     */
    public String getTreeCode()
    {
        return treeCode;
    }

    /**
     * Sets tree code.
     *
     * @param treeCode the tree code
     */
    public void setTreeCode(String treeCode)
    {
        this.treeCode = treeCode;
    }

    /**
     * Gets tree parent code.
     *
     * @return the tree parent code
     */
    public String getTreeParentCode()
    {
        return treeParentCode;
    }

    /**
     * Sets tree parent code.
     *
     * @param treeParentCode the tree parent code
     */
    public void setTreeParentCode(String treeParentCode)
    {
        this.treeParentCode = treeParentCode;
    }

    /**
     * Gets tree name.
     *
     * @return the tree name
     */
    public String getTreeName()
    {
        return treeName;
    }

    /**
     * Sets tree name.
     *
     * @param treeName the tree name
     */
    public void setTreeName(String treeName)
    {
        this.treeName = treeName;
    }

    /**
     * Gets parent menu id.
     *
     * @return the parent menu id
     */
    public String getParentMenuId()
    {
        return parentMenuId;
    }

    /**
     * Sets parent menu id.
     *
     * @param parentMenuId the parent menu id
     */
    public void setParentMenuId(String parentMenuId)
    {
        this.parentMenuId = parentMenuId;
    }

    /**
     * Gets parent menu name.
     *
     * @return the parent menu name
     */
    public String getParentMenuName()
    {
        return parentMenuName;
    }

    /**
     * Sets parent menu name.
     *
     * @param parentMenuName the parent menu name
     */
    public void setParentMenuName(String parentMenuName)
    {
        this.parentMenuName = parentMenuName;
    }

    /**
     * Is sub boolean.
     *
     * @return the boolean
     */
    public boolean isSub()
    {
        return isSub(this.tplCategory);
    }

    /**
     * Is sub boolean.
     *
     * @param tplCategory the tpl category
     * @return the boolean
     */
    public static boolean isSub(String tplCategory)
    {
        return tplCategory != null && StringUtils.equals(GenConstants.TPL_SUB, tplCategory);
    }

    /**
     * Is tree boolean.
     *
     * @return the boolean
     */
    public boolean isTree()
    {
        return isTree(this.tplCategory);
    }

    /**
     * Is tree boolean.
     *
     * @param tplCategory the tpl category
     * @return the boolean
     */
    public static boolean isTree(String tplCategory)
    {
        return tplCategory != null && StringUtils.equals(GenConstants.TPL_TREE, tplCategory);
    }

    /**
     * Is crud boolean.
     *
     * @return the boolean
     */
    public boolean isCrud()
    {
        return isCrud(this.tplCategory);
    }

    /**
     * Is crud boolean.
     *
     * @param tplCategory the tpl category
     * @return the boolean
     */
    public static boolean isCrud(String tplCategory)
    {
        return tplCategory != null && StringUtils.equals(GenConstants.TPL_CRUD, tplCategory);
    }

    /**
     * Is super column boolean.
     *
     * @param javaField the java field
     * @return the boolean
     */
    public boolean isSuperColumn(String javaField)
    {
        return isSuperColumn(this.tplCategory, javaField);
    }

    /**
     * Is super column boolean.
     *
     * @param tplCategory the tpl category
     * @param javaField   the java field
     * @return the boolean
     */
    public static boolean isSuperColumn(String tplCategory, String javaField)
    {
        if (isTree(tplCategory))
        {
            return StringUtils.equalsAnyIgnoreCase(javaField,
                    ArrayUtils.addAll(GenConstants.TREE_ENTITY, GenConstants.BASE_ENTITY));
        }
        return StringUtils.equalsAnyIgnoreCase(javaField, GenConstants.BASE_ENTITY);
    }
}