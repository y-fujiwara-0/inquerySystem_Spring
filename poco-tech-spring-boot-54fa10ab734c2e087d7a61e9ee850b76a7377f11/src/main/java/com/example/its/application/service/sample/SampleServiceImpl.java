package com.example.its.application.service.sample;

import com.example.its.domain.model.sample.Sample;
import com.example.its.domain.repository.sample.SampleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * {@inheritDoc}
 */
@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {

	private final SampleRepository sampleRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Page<Sample> findAll(final Pageable pageable) {
		return sampleRepository.findAll(pageable);
	}
}
