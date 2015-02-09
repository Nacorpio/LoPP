package com.lopp.game.format;

import com.lopp.game.api.serialization.ISerializable;

public class Tag implements ISerializable {

	private String name;
	private ISerializable data;
	
	public Tag(String par1, ISerializable par2) {
		name = par1;
		data = par2;
	}

	public final String getName() {
		return name;
	}
	
	public final Tag setData(ISerializable par1) {
		if (data != par1 && data != null) {
			data = par1;
		}
		return this;
	}
	
	public final ISerializable getData() {
		return data;
	}
	
	@Override
	public final String getIdString() {
		return "tag";
	}

	@Override
	public final String getNativeString() {
		return null;
	}

	@Override
	public final String getLocalString() {
		return "{"+name+":{"+data.getLocalString()+"}}";
	}

}
