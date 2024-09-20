package com.example.its.presentation.form.common;

import lombok.Data;

import java.io.Serializable;

/**
 * ページャー情報取得用Form
 */
@Data
public class PageForm implements Serializable {

	/** ページ番号 */
	private final Integer page;

	public Integer getPage() {
		return page == null ? 0 : page;
	}
}
