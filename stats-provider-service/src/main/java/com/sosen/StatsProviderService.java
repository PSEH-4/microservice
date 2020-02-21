package com.sosen;

import java.util.List;

import com.sosen.service.AbstractService;

public class StatsProviderService extends AbstractService {
	public List<Stat> getStatData(String arg) {
		String[] args = arg.split(",");
		return new StatsProvider().getStatFor(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
	}
}
