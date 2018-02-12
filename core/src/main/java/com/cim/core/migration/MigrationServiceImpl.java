package com.cim.core.migration;

import org.springframework.stereotype.Service;

@Service
public class MigrationServiceImpl implements MigrationService
{
	@Override
	public MigrationResponse migrate(MigrationRequest request)
	{
		MigrationResponse response = new MigrationResponse();
		return response;
	}
}
