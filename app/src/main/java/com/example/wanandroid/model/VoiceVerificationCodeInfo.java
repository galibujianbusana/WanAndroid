package com.example.wanandroid.model;


public class VoiceVerificationCodeInfo {
    private String mobile;
    private String msgType;

    /**
     * 消息类型
     *  SMS_ACCOUNT_CODE：开户   *不需要
     *  SMS_REGISTER_CODE：注册
     *  SMS_FORGETPWD_CODE：忘记密码
     *  SIGN_CONTRACT_CODE：签订合同
     *  REFUND_CODE：退款  *不需要
     *  CANCEL_ORDER_CODE：取消订单
     *  MODIFY_OID_TELEPHONE_CODE：修改旧手机号
     *  MODIFY_NEW_TELEPHONE_CODE：修改新手机号
     *  SMS_BINDCARD_CANCEL_CODE：解绑卡验证码
     *  SMS_LOGIN_BIND_CODE：三方登录绑定手机号
     */
    public VoiceVerificationCodeInfo(String mobile, String msgType) {
        this.mobile = mobile;
        this.msgType = msgType;
    }
}

