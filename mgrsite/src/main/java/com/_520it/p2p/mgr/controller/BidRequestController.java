package com._520it.p2p.mgr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.p2p.base.domain.UserFile;
import com._520it.p2p.base.domain.UserInfo;
import com._520it.p2p.base.query.UserFileQueryObject;
import com._520it.p2p.base.service.IRealAuthService;
import com._520it.p2p.base.service.IUserFileService;
import com._520it.p2p.base.service.IUserInfoService;
import com._520it.p2p.base.util.BidConst;
import com._520it.p2p.base.util.JSONResult;
import com._520it.p2p.business.domain.BidRequest;
import com._520it.p2p.business.query.BidRequestQueryObject;
import com._520it.p2p.business.service.IBidRequestService;

/**
 * 后台借款审核相关的控制器
 * 
 * @author Administrator
 * 
 */
@Controller
public class BidRequestController {
	@Autowired
	private IBidRequestService bidRequestService;
	@Autowired
	private IUserInfoService userInfoService;
	@Autowired
	private IUserFileService userFileService;
	@Autowired
	private IRealAuthService realAuthService;

	/**
	 * 借款审核列表
	 */
	@RequestMapping("bidrequest_publishaudit_list")
	public String publishAudit(@ModelAttribute("qo") BidRequestQueryObject qo,
			Model model) {
		qo.setBidRequestState(BidConst.BIDREQUEST_STATE_PUBLISH_PENDING);// 待发布状态
		model.addAttribute("pageResult", bidRequestService.query(qo));
		return "bidrequest/publish_audit";
	}
	/**
	 * 满标一审列表
	 */
	@RequestMapping("bidrequest_audit1_list")
	public String audit1List(@ModelAttribute("qo") BidRequestQueryObject qo,
			Model model) {
		qo.setBidRequestState(BidConst.BIDREQUEST_STATE_APPROVE_PENDING_1);// 待发布状态
		model.addAttribute("pageResult", bidRequestService.query(qo));
		return "bidrequest/audit1";
	}
	
	/**
	 * 满标二审列表
	 */
	@RequestMapping("bidrequest_audit2_list")
	public String audit2List(@ModelAttribute("qo") BidRequestQueryObject qo,
			Model model) {
		qo.setBidRequestState(BidConst.BIDREQUEST_STATE_APPROVE_PENDING_2);// 待发布状态
		model.addAttribute("pageResult", bidRequestService.query(qo));
		return "bidrequest/audit2";
	}

	/**
	 * 发标前审核
	 */
	@RequestMapping("bidrequest_publishaudit")
	@ResponseBody
	public JSONResult bidRequestPublishAudit(Long id, int state, String remark) {
		JSONResult jsonResult = new JSONResult();
		try {
			bidRequestService.publishAudit(id, state, remark);
		} catch (Exception e) {
			jsonResult.mark(e.getMessage());
			e.printStackTrace();
		}
		return jsonResult;
	}
	
	/**
	 * 满标一审审核
	 */
	@RequestMapping("bidrequest_audit1")
	@ResponseBody
	public JSONResult fullAudit1(Long id, int state, String remark) {
		JSONResult jsonResult = new JSONResult();
		try {
			bidRequestService.fullAudit1(id, state, remark);
		} catch (Exception e) {
			jsonResult.mark(e.getMessage());
			e.printStackTrace();
		}
		return jsonResult;
	}
	
	/**
	 * 满标二审审核
	 */
	@RequestMapping("bidrequest_audit2")
	@ResponseBody
	public JSONResult fullAudit2(Long id, int state, String remark) {
		JSONResult jsonResult = new JSONResult();
		try {
			bidRequestService.fullAudit2(id, state, remark);
		} catch (Exception e) {
			jsonResult.mark(e.getMessage());
			e.printStackTrace();
		}
		return jsonResult;
	}

	/**
	 * 借款申请详情
	 */
	@RequestMapping("borrow_info")
	public String borrowInfo(Model model, Long id) {
		BidRequest bidRequest = bidRequestService.selectByPrimaryKey(id);
		UserInfo userInfo = userInfoService.selectByPrimaryKey(bidRequest
				.getCreateUser().getId());

		model.addAttribute("bidRequest", bidRequest);
		model.addAttribute("userInfo", userInfo);
		model.addAttribute("realAuth",
				realAuthService.selectByUserInfoId(userInfo.getId()));
		model.addAttribute("audits", bidRequestService.listByBidRequestId(id));
		//借款人的风控资料信息
		UserFileQueryObject qo = new UserFileQueryObject();
		qo.setApplierId(userInfo.getId());
		qo.setState(UserFile.STATE_AUDIT);
		qo.setPageSize(-1);
		model.addAttribute("userFiles", userFileService.queryForList(qo));
		
		return "bidrequest/borrow_info";
	}
}
