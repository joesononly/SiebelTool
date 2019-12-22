package com.example.pojo;/*
 * @Created by Administrator
 * @Created 2019/12/17
 * @Comment
 */

public class BaseModal {
    //主键
    private String id;
    //修改日期
    private String lastUpdate;
    //修改人
    private String lastUpdateBy;
    //修改人工号
    private String lastUpdateByCode;

    /*查询条件*/
    //开始时间
    private String startDate;
    //结束时间
    private String endDate;

    //当前页面
    private Integer page;
    //一页行数
    private Integer rows;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public String getLastUpdateByCode() {
        return lastUpdateByCode;
    }

    public void setLastUpdateByCode(String lastUpdateByCode) {
        this.lastUpdateByCode = lastUpdateByCode;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
