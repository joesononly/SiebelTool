package com.example.pojo;/*
 * @Created by Administrator
 * @Created 2019/12/13
 * @Comment BS对应的方法信息
 */

public class BusinessServiceMethod {

    private String id;
    //BS
    private String businessService;
    //方法
    private String methodName;
    //修改人
    private String lastBy;
    //修改人编码
    private String lastByCode;
    //程序语言
    private String ProgLang;
    //代码
    private String script;
    //修改时间
    private String lastUpd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBusinessService() {
        return businessService;
    }

    public void setBusinessService(String businessService) {
        this.businessService = businessService;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getLastBy() {
        return lastBy;
    }

    public void setLastBy(String lastBy) {
        this.lastBy = lastBy;
    }

    public String getLastByCode() {
        return lastByCode;
    }

    public void setLastByCode(String lastByCode) {
        this.lastByCode = lastByCode;
    }

    public String getProgLang() {
        return ProgLang;
    }

    public void setProgLang(String progLang) {
        ProgLang = progLang;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getLastUpd() {
        return lastUpd;
    }

    public void setLastUpd(String lastUpd) {
        this.lastUpd = lastUpd;
    }
}
