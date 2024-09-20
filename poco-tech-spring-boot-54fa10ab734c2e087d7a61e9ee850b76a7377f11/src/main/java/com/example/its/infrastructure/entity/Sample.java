package com.example.its.infrastructure.entity;

import lombok.Data;
import java.time.LocalDateTime;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.GeneratedValue;
import org.seasar.doma.GenerationType;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * サンプルエンティティ
 */
@Entity
@Table(name = "sample")
@Data
public class Sample {

	/** サンプルID */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sample_id")
	private Long sampleId;

	/** サンプル名 */
	@Column(name = "name")
	private String name;

	/** 作成日時 */
	@Column(name = "created_at")
	private LocalDateTime createdAt;
}
