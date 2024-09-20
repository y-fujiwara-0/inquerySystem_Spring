package com.example.its.presentation.controller.sample;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;

/**
 * ソート条件
 */
@RequiredArgsConstructor
@Getter
public enum SortCondition {
	SAMPLE_ID_ASC("sample_id", Sort.Direction.ASC),
	;

	private final String property;
	private final Sort.Direction direction;

	private static final SortCondition DEFAULT = SAMPLE_ID_ASC;

	/**
	 * コンストラクタ
	 * @param ordinal 序数
	 */
	public static SortCondition of(final Integer ordinal) {
		if (ObjectUtils.isEmpty(ordinal)) {
			return DEFAULT;
		}
		return Arrays.stream(SortCondition.values())
				.filter(element -> ordinal.equals(element.ordinal()))
				.findFirst()
				.orElse(DEFAULT);
	}

	/**
	 * ソート条件を取得します。
	 * @return ソート条件
	 */
	public Sort getSort() {
		return Sort.by(new Sort.Order(direction, property));
	}
}
