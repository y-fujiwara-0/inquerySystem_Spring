package com.example.its.infrastructure.dao;

import com.example.its.infrastructure.entity.Sample;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.Result;
import org.seasar.doma.jdbc.SelectOptions;

import java.util.List;

/**
 * サンプルDAO
 */
@Dao
@ConfigAutowireable
public interface SampleDao {

	/**
	 * 主キーを指定してサンプルを検索します。
	 * @param sampleId サンプルID
	 * @return サンプルエンティティ
	 */
	@Select
	Sample selectById(Long sampleId);

	/**
	 * サンプルをすべて取得します。
	 * @param selectOptions 検索オプション
	 * @param orderBy ソート文字列（指定なしの場合はnull）
	 * @return サンプルエンティティのリスト
	 */
	@Select
	List<Sample> selectAll(SelectOptions selectOptions, String orderBy);

	/**
	 * サンプルを登録します。
	 * @param entity サンプルエンティティ
	 * @return 登録結果
	 */
	@Insert
	int insert(Sample entity);

	/**
	 * サンプルを更新します。
	 * @param entity サンプルエンティティ
	 * @return 更新結果
	 */
	@Update
	int update(Sample entity);

	/**
	 * サンプルを削除します。
	 * @param entity サンプルエンティティ
	 * @return 削除結果
	 */
	@Delete
	int delete(Sample entity);
}
