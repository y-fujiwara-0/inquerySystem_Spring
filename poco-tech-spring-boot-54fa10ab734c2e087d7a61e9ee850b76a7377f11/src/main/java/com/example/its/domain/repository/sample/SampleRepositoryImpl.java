package com.example.its.domain.repository.sample;

import com.example.its.infrastructure.dao.SampleDao;
import com.example.its.domain.model.sample.Sample;
import com.example.its.infrastructure.mapper.SampleMapper;
import com.example.its.presentation.helper.pageable.PageableHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * {@inheritDoc}
 */
@Repository
@RequiredArgsConstructor
public class SampleRepositoryImpl implements SampleRepository {

	private final SampleDao sampleDao;

	private final SampleMapper sampleMapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Page<Sample> findAll(final Pageable pageable) {
		return PageableHelper.paginator(pageable)
				.findWithSort(sampleDao::selectAll)
				.map(sampleMapper::toModel);
	}
}
