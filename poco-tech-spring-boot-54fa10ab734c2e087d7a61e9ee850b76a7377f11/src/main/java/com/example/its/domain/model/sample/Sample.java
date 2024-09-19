package com.example.its.domain.model.sample;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sample {

	/** サンプルID */
	Long sampleId;

	/** サンプル名 */
	String name;

	/** 作成日時 */
	LocalDateTime createdAt;
}
