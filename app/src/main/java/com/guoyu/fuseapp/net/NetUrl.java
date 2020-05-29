package com.guoyu.fuseapp.net;

/**
 * Created by Administrator on 2019/9/29.
 */

public class NetUrl {
//    public static final String BASE_URL = "http://192.168.1.116:8080/";
//    public static final String BASE_URL = "http://192.168.1.102:8080/";
//    public static final String BASE_URL = "http://39.98.188.171:8088/";
    public static final String BASE_URL = "http://112.101.203.127:9999/";
    public static final String H5BASE_URL = "http://xfsysh5.5ijiaoyu.cn/";
    //用户获取验证码
    public static final String registerPhone = "/CitizenUser/registerPhone";
    //验证码校验
    public static final String yzmCode = "/CitizenUser/yzmCode";
    //手机号注册
    public static final String register = "/CitizenUser/register";
    //app用户登录
    public static final String loginApp = "/CitizenUser/loginApp";
    //前台实名认证
    public static final String realNameAuthentication = "/CitizenUser/realNameAuthentication";
    //获取用户个人信息
    public static final String CitizenUsergetOne = "/CitizenUser/getOne";
    //投诉咨询列表
    public static final String AppConsultationInfoqueryList = "/AppConsultationInfo/queryList";
    //个人信息修改
    public static final String CitizenUserupdate = "/CitizenUser/update";
    //用户手机号验证码发送(忘记密码)
    public static final String CitizenUserregisterPhoneWjmm = "/CitizenUser/registerPhoneWjmm";
    //用户手机号验证码发送(忘记密码)
    public static final String CitizenUserforgetThePassword = "/CitizenUser/forgetThePassword";
    //发布咨询投诉
    public static final String AppConsultationInfotoUpdate = "/AppConsultationInfo/toUpdate";
    //查询更多模板
    public static final String AppCitizenIndexfindAllInfoMore = "/AppCitizenIndex/findAllInfoMore";
    //查询全部轮播图
    public static final String AppBannerInfoqueryList = "/AppBannerInfo/queryList";
    //查询首页展示模板
    public static final String AppCitizenIndexfindAllInfo = "/AppCitizenIndex/findAllInfo";
    //咨询投诉详情
    public static final String AppConsultationInfogetOne = "/AppConsultationInfo/getOne";
    //政务指南列表
    public static final String AppGovernmentInfoqueryList = "/AppGovernmentInfo/queryList";
    //展示政务指南
    public static final String AppCitizenIndexfindNewGovernment = "/AppCitizenIndex/findNewGovernment";
    //城市风采列表
    public static final String AppCityInfoqueryList = "/AppCityInfo/queryList";
    //城市微观
    public static final String AppMiniCityInfoqueryList = "/AppMiniCityInfo/queryList";
    //发布城市微观(城市微观修改提交)
    public static final String AppMiniCityInfotoUpdate = "AppMiniCityInfo/toUpdate";
    //删除城市微观
    public static final String AppMiniCityInfotoDelete = "/AppMiniCityInfo/toDelete";
    //首页展示便民查询
    public static final String AppCitizenIndexfindConvenienceQuery = "/AppCitizenIndex/findConvenienceQuery";
    //展示便民查询详细
    public static final String AppCitizenIndexfindByFunCode = "/AppCitizenIndex/findByFunCode";
    //获取社区信息(社区列表)
    public static final String AppCommunityServiceInfofindCommunity = "/AppCommunityServiceInfo/findCommunity";
    //获取社区信息(社区分类)
    public static final String AppCommunityServiceInfofindType = "/AppCommunityServiceInfo/findType";
    //社区信息列表
    public static final String AppCommunityServiceInfoqueryList = "/AppCommunityServiceInfo/queryList";
    //APP搜索
    public static final String AppSearchqueryList = "/AppSearch/queryList";
    //首页展示便民服务
    public static final String AppCitizenIndexfindConvenienceNotice = "/AppCitizenIndex/findConvenienceNotice";
    //APP家政服务
    public static final String AppHouseServiceInfoqueryList = "/AppHouseServiceInfo/queryList";
    //APP家政服务详情
    public static final String AppHouseServiceInfogetOne = "/AppHouseServiceInfo/getOne";
    //查询全部安全服务
    public static final String AppSaveInfoqueryList = "/AppSaveInfo/queryList";
    //安全服务详情
    public static final String AppSaveInfogetOne = "/AppSaveInfo/getOne";
    //部门
    public static final String AppConsultationInfofindDepartment="/AppConsultationInfo/findDepartment";
    //查询全部便民通知
    public static final String AppConvenienceNoticequeryList="/AppConvenienceNotice/queryList";
    //便民通知详情
    public static final String AppConvenienceNoticegetOne="/AppConvenienceNotice/getOne";
    //最新版本信息
    public static final String AppVersionInfonewVersion="/AppVersionInfo/newVersionCity";
    //城市微观获取一条
    public static final String AppMiniCityInfogetOne = "/AppMiniCityInfo/getOne";
    //所有小区
    public static final String AppCommunityServiceInfofindArea = "/AppCommunityServiceInfo/findArea";
    //文体服务列表
    public static final String AppStyleInfoqueryList = "/AppStyleInfo/queryList";
    //文体服务详情
    public static final String AppStyleInfogetOne="/AppStyleInfo/getOne";
    //APP全部中介服务
    public static final String AppAgentServicequeryList="/AppAgentService/queryList";
    //上传头像
    public static final String apiupdateheadPortrait="/CitizenUser/updateheadPortrait";
    //社区详情
    public static final String AppCommunityServiceInfogetOne = "/AppCommunityServiceInfo/getOne";
    //查询政务指南分类
    public static final String AppGovernmentInfofindType= "/AppGovernmentInfo/findType";
    //投诉咨询类别列表
    public static final  String AppConsultationInfofindType = "/AppConsultationInfo/findType";
    //查询unionid是否存在
    public static final  String CitizenUserselectUnionid = "/CitizenUser/selectUnionid";
    //查看点赞及浏览次数
    public static final  String AppShareListPraiseTimesfindNum = "/AppShareListPraiseTimes/findNum";
    //点赞
    public static final  String AppShareListPraiseTimesclickLikes = "/AppShareListPraiseTimes/clickLikes";
    //政务指南详情
    public static final  String AppGovernmentInfogetOne = "/AppGovernmentInfo/getOne";
    //中介服务详情
    public static final  String AppAgentServicegetOne = "/AppAgentService/getOne";
    //文体活动类型列表
    public static final  String StyleInfoItemqueryList = "/StyleInfoItemApp/queryListApp";
    //家政服务分类
    public static final  String HouseServiceInfoItemAppqueryListApp = "/HouseServiceInfoItemApp/queryListApp";
    //查询全部预约大厅接口
    public static final  String AppBookingBusinessqueryListHall = "/AppBookingBusiness/queryListHall";
    //查询预约部门接口
    public static final  String AppBookingBusinessqueryListDep = "/AppBookingBusiness/queryListDep";
    //查询全部预约业务分类接口
    public static final  String AppBookingBusinessqueryListBusiness = "/AppBookingBusiness/queryListBusiness";
    //查询全部业务事项接口
    public static final  String AppBookingBusinessqueryListDetail = "/AppBookingBusiness/queryListDetails";
    //全部业务事项申请接口
    public static final  String AppBookingBusinessqueryListManage = "/AppBookingBusiness/queryListManage";
    //新增 业务事项申请
    public static final  String AppBookingBusinesstoUpdate = "/AppBookingBusiness/toUpdate";
    //查询我的预约接口
    public static final  String AppBookingBusinessqueryListMes = "/AppBookingBusiness/queryListMes";
    //预约信息详情
    public static final  String AppBookingBusinessgetOneMes = "/AppBookingBusiness/getOneMes";
    //应用中心列表
    public static final  String AppCenterqueryList = "/AppCenter/queryList";
    //zjhd
    public static final  String AppGovernEnterInteractionqueryList = "/AppGovernEnterInteraction/queryList";
    //详情
    public static final String AppGovernEnterInteractiongetOne = "/AppGovernEnterInteraction/getOne";
    //评论
    public static final String AppGovernEnterInteractiontoUpdate = "/AppGovernEnterInteraction/toUpdate";
    //点赞
    public static final String AppGovernEnterInteractionlikeNum= "/AppGovernEnterInteraction/likeNum";
    //APP公告轮播列表
    public static final String AppointmentNoticeAppqueryListlimint5= "/AppointmentNoticeApp/queryListlimint5";
    //APP查询全部预约公告
    public static final String AppointmentNoticeAppqueryList= "/AppointmentNoticeApp/queryList";
    //通过预约公告ID查询详情
    public static final String AppointmentNoticeAppgetOne= "/AppointmentNoticeApp/getOne";
    //查询全部大厅或部门
    public static final String AppAppointmentqueryList= "/AppAppointment/queryList";
    //根据部门ID查询数据
    public static final String AppAppointmentgetOneByTime= "/AppAppointment/getOneByTime";
    //用户新增预约信息
    public static final String AppAppointmentinsertInformationApp= "/AppAppointment/insertInformationApp";
    //查询我的预约信息
    public static final String AppAppointmentgetByAppointmentApp= "/AppAppointment/getByAppointmentApp";
    //取消预约
    public static final String AppAppointmentdeleteById= "/AppAppointment/deleteById";
}
