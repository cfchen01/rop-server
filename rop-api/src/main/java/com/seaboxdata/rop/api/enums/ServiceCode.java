package com.seaboxdata.rop.api.enums;

/**
 * @Author: sqq
 * @Description: serviceException异常code码
 * @Date: 2020/1/7
 **/
public class ServiceCode {
    /**
     * 前端会接受403的异常信息做展示，其他的错误码当做普通异常不进行展示
     */
    public static final String SERVICE_CODE_403 = "403";

    public static final String SERVICE_CODE_444 = "444";

    public static final String SERVICE_CODE_555 = "555";

    public static final String DATA_NOT_EXIST = "该数据不存在或已被删除";

    public static final String DATA_IS_EMPTY = "参数为空,请传入有效数据再进行尝试！";

    public static final String DATA_IS_RELATED = "该供给清单被需求清单所关联引用，不可删除，请先删除对应需求清单，再删除此供给清单！";
}
