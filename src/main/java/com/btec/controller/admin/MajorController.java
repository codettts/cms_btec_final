package com.btec.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.btec.dto.MajorDTO;
import com.btec.service.IMajorService;
import com.btec.util.MessageUtil;

@Controller
public class MajorController {
	
	@Autowired
	private IMajorService majorService;

	@Autowired
	private MessageUtil messageUtil;
	
	@RequestMapping(value = "/admin/major-manage", method = RequestMethod.GET)
	public ModelAndView showList(@RequestParam("page") int page, @RequestParam("limit") int limit) {
		MajorDTO model = new MajorDTO();
		model.setPage(page);
		model.setLimit(limit);
		ModelAndView mav = new ModelAndView("admin/major/listMajor");
		Pageable pageable = new PageRequest(page - 1, limit);
		model.setListResult(majorService.findAll(pageable));
		model.setTotalItem(majorService.getTotalItem());
		model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
		mav.addObject("model", model);
		return mav;
	}
	@RequestMapping(value = "/admin/major-manage/edit", method = RequestMethod.GET)
	public ModelAndView editNew(@RequestParam(value = "majorId", required = false) Long majorId, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/major/editMajor");
		MajorDTO model = new MajorDTO();
		if (majorId != null) {
			model = majorService.findById(majorId);
		}
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			mav.addObject("message", message.get("message"));
			mav.addObject("alert", message.get("alert"));
		}
		mav.addObject("model", model);
		return mav;
	}
}
