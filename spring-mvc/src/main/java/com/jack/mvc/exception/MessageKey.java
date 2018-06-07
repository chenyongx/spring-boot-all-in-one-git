package com.jack.mvc.exception;

/**
 * 状态结果枚举定义
 *
 * @author yangyueming
 */
public interface MessageKey {

    String RETURN_OK = "0000";
    String SYSTEM_ERROR = "1001";
    String REQUEST_MORE_BY_MOBILE = "1002";
    String USER_NAME_IS_NULL = "1003";
    String PASSWORD_IS_NULL = "1004";
    String RAW_DATA_ANALYSIS_ERROR = "1005";
    String LOGIN_ERROR = "1006";
    String SOURCE_DATA_NULL = "1007";
    String FILE_SIZE_OVER_UPPER_LIMIT = "1008";
    String USER_NAME_IS_EXIST = "1013";
    String CHECK_CODE_IS_NULL = "1014";
    String CHECK_CODE_IS_INVALID = "1015";
    String NICKNAME_IS_NULL = "1017";
    String SEX_IS_NULL = "1018";
    String ACCESS_TOKEN_IS_INVALID = "1019";
    String STATURE_IS_NULL = "1020";
    String WEIGHT_IS_NULL = "1021";
    String BIRTHDAY_IS_NULL = "1022";
    String USER_NO_EXIST_OR_PASSWORD_IS_WRONG = "1029";
    /**
     * 参数错误
     */
    String PARAMETER_ERROR = "1031";
    String ACCESS_TOKEN_IS_NULL = "1032";
    /**
     * 当天请求次数已经达到上限
     */
    String UP_ACCESS_COUNT = "1042";
    /**
     * 同一个帐号限制每天发送10次
     */
    String UP_ACCESS_COUNT_REGISTER = "1042";
    /**
     * 同一个邮箱发送激活邮件限制：10次
     */
    String UP_ACCESS_COUNT_ACTIVATE = "1042";
    String APPKEY_IS_INVALID = "1045";
    /**
     * 邮件发送失败
     */
    String FAILED_TO_SEND_EMAIL = "1080";
    /**
     * 运动数据重复提交
     */
    String SPORT_DATA_REPEAT_SUBMIT = "1082";
    String TIMEZONE_ERROR = "1083";
    /**
     * 帐号已经绑定,不能中其他操作
     */
    String ACCOUNT_IS_BIND = "2001";
    /**
     * 只用一种帐号类型存在,不能解除绑定
     */
    String ACCOUNT_IS_ONLY_ONE = "2002";
    /**
     * 帐号没有绑定,比如mobile没有绑定过,不能解除mobile的绑定
     */
    String ACCOUNT_NOT_BIND = "2003";
    /**
     * 邮箱已经被激活
     */
    String EMAIL_IS_ACTIVATED = "2006";
    /**
     * 电话号码没有注册
     */
    String MOBILE_IS_NOT_REGISTERED = "2007";
    /**
     * 邮箱没有注册
     */
    String EMAIL_IS_NOT_REGISTERED = "2008";
    /**
     * 邮箱已注册,邮件已过期,请重新发送激活邮件
     */
    String EMIL_NOT_ACTIVATED_MAIL_EXPIRED = "2010";
    /**
     * 邮箱已注册,邮件未过期,请打开激活邮件进行激活
     */
    String EMIL_NOT_ACTIVATED_MAIL_NOT_EXPIRED = "2011";
    /**
     * 帐号无效
     */
    String ACCOUNT_IS_INVALID = "2013";
    /**
     * 头像文件大小超过限制
     */
    String HEAD_PIC_FILE_TOO_LARGE = "2016";
    /**
     * 密码错误次数超过上限
     */
    String PWD_ERROR_COUNT_MAX = "2018";
    String FIRMWARE_NO_EXIST = "2051";
    /**
     * 时区信息为空
     */
    String TIMEZONE_IS_NULL = "3001";
    /**
     * 紧急联系人电话号码格式错误
     */
    String INCOMPLETE_PHONE_NO = "3002";
    /**
     * 注册时间错误
     */
    String REGISTER_TIME_ERROR = "3003";
    /**
     * 数据为空
     */
    String DATA_IS_NULL = "5081";
    /**
     * 用户已经加入团队
     */
    String USER_JOIN_TEAM = "12001";
    /**
     * 用户没有加入团队
     */
    String USER_NOT_JOIN_TEAM = "12002";
    /**
     * 团队无效,不存在或者已经过期
     */
    String USER_TEAM_IS_INVALID = "12003";
    /**
     * 用户不是团队管理员,不能设置团队信息
     */
    String USER_IS_NOT_ADMIN = "12004";
    /**
     * 管理员不能删除他自己
     */
    String ADMIN_CONNOT_BE_DELETE = "12005";
    /**
     * 路书已经上传
     */
    String ROUTE_IS_EXSIT = "13001";
    /**
     * 找不到路书
     */
    String ROUTE_IS_NOT_FOUND = "13002";
    /**
     * 只有路书作者才能修改路书
     */
    String ONLY_AUTHOR_CAN_ROAD_ROUTE = "13003";
    /**
     * 自行车导航路书文件大小超过上限
     */
    String COROS_ROUTE_FILE_TOO_LARGE = "13004";
    /**
     * 缩率图文件大小超过上限
     */
    String IMAGE_DATA_FILE_TOO_LARGE = "14001";
    /**
     * 运动数据文件大小超过上限
     */
    String SPORT_DATA_FILE_TOO_LARGE = "14002";
    /**
     * （紧急联系人）半小时内只能发送1条短信
     */
    String SMS_SEND_ONLY_30_MINUTE = "15001";
    /**
     * （紧急联系人）一天内只能发送10条短信
     */
    String MAX_10_SMS_SEND_EVERYDAY = "15002";
    /**
     * 短信发送失败，请检查紧急联系人电话。
     */
    String SEND_SMS_FAILED = "15003";
    /**
     * 固件已经存在,不需要重复发布
     */
    String FIRMWARE_IS_EXIST = "9005";
    /**
     * 固件压缩文件超过上限
     */
    String FIRMWARE_FILE_TOO_LARGE = "9006";
}
