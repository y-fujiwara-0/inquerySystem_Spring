package com.example.its.domain.repository.sample;

import com.example.its.domain.model.sample.Sample;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * サンプルに関するリポジトリ
 */
public interface SampleRepository {

	/**
	 * すべてのサンプルを取得します。
	 * @param pageable ページ情報
	 * @return すべてのサンプル
	 */
	Page<Sample> findAll(final Pageable pageable);
}
