package cn.com.yusys.search.bean;


/**
 * @author 94946
 * @date 2019/2/12
 * @DESC 全文检索实体类
 */
public class AstTable {
    //资产编号
    private String assetNo;
    //表名称
    private String name;
    //表中文描述
    private String nameDesc;
    //字段名称
    private String colName;
    //字段描述
    private String colDesc;
    //表空间名称
    private String spaceName;
    //表空间描述
    private String spaceDesc;

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameDesc() {
        return nameDesc;
    }

    public void setNameDesc(String nameDesc) {
        this.nameDesc = nameDesc;
    }

    public String getColName() {
        return colName;
    }

    public void setColName(String colName) {
        this.colName = colName;
    }

    public String getColDesc() {
        return colDesc;
    }

    public void setColDesc(String colDesc) {
        this.colDesc = colDesc;
    }

    public String getSpaceName() {
        return spaceName;
    }

    public void setSpaceName(String spaceName) {
        this.spaceName = spaceName;
    }

    public String getSpaceDesc() {
        return spaceDesc;
    }

    public void setSpaceDesc(String spaceDesc) {
        this.spaceDesc = spaceDesc;
    }
}
