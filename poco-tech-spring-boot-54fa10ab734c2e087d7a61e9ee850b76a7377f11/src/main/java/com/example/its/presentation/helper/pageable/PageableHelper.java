package com.example.its.presentation.helper.pageable;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * ページャー Helper
 */
public class PageableHelper {

	public static Paginator paginator(Pageable pageable) {
		return new Paginator(pageable);
	}

	@AllArgsConstructor(access = AccessLevel.PRIVATE)
	public static class Paginator {

		private final Pageable pageable;

		/**
		 * ステートメントを実行し、結果をページで返します。
		 * @param selectStatement ステートメント
		 * @return ページ
		 */
		public <T> Page<T> find(final Function<SelectOptions, List<T>> selectStatement) {
			final SelectOptions selectOptions = selectOptions(pageable);
			final List<T> result = selectStatement.apply(selectOptions);
			return new PageImpl<>(result, pageable, selectOptions.getCount());
		}

		/**
		 * ソートを用いてステートメントを実行し、結果をページで返します。
		 * @param selectStatement ステートメント
		 * @return ページ
		 */
		public <T> CustomPage<T> findWithSort(final BiFunction<SelectOptions, String, List<T>> selectStatement) {
			final SelectOptions selectOptions = selectOptions(pageable);
			final List<T> result = selectStatement.apply(selectOptions, orderBy(pageable.getSort()));
			return new CustomPageImpl<>(result, pageable, selectOptions.getCount());
		}
	}

	/**
	 * offset と limit を適用した検索オプションを生成します。
	 * @param pageable {@link Pageable}
	 * @return 検索オプション
	 */
	private static SelectOptions selectOptions(final Pageable pageable) {
		return SelectOptions.get()
				.offset((int) pageable.getOffset())
				.limit(pageable.getPageSize())
				.count();
	}

	/**
	 * 指定のソート条件からSQLのソート文を生成します。
	 * @param sort ソート条件
	 * @return SQLのソート文字列
	 */
	private static String orderBy(final Sort sort) {
		if (ObjectUtils.isEmpty(sort)) {
			return "";
		}

		final List<String> orderList = StreamSupport.stream(sort.spliterator(), false)
				.map(order -> order.getProperty() + " " + order.getDirection())
				.collect(Collectors.toList());

		if (CollectionUtils.isEmpty(orderList)) {
			return "";
		}

		return "ORDER BY " + String.join(", ", orderList);
	}
}
