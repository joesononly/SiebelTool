package com.example.pojo;/*
 * @Created by Administrator
 * @Created 2019/12/13
 * @Comment BS对应的方法信息
 */

public class BusinessServiceMethod extends BaseModal {

    //BS
    private String businessService;
    //方法
    private String methodName;
    //程序语言
    private String ProgLang;
    //代码
    private String script;
    //修改时间
    private String lastUpd;

    private BusinessServiceMethod destMethod;


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

    public BusinessServiceMethod getDestMethod() {
        return destMethod;
    }

    public void setDestMethod(BusinessServiceMethod destMethod) {
        this.destMethod = destMethod;
    }
}
