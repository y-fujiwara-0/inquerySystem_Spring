package com.example.its.presentation.controller.sample;

import com.example.its.application.service.sample.SampleService;
import com.example.its.domain.model.sample.Sample;
import com.example.its.presentation.form.common.PageForm;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * サンプルコントローラー
 */
@Controller
@RequiredArgsConstructor
public class SampleController {

	@Value("${page.common.size}")
	private Integer pageSize;

	private final SampleService sampleLogic;

	/**
	 * サンプル画面を表示します。
	 * @return サンプル画面
	 */
	@GetMapping("/sample")
	public String sample(Model model, PageForm pageForm) {
		val pageRequest = PageRequest.of(pageForm.getPage(), pageSize, SortCondition.SAMPLE_ID_ASC.getSort());

		Page<Sample> samplePage = sampleLogic.findAll(pageRequest);
		model.addAttribute("samplePage", samplePage);

		return "sample/sample";
	}
}
