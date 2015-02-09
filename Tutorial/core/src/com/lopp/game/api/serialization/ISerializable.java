package com.lopp.game.api.serialization;

public interface ISerializable {

	/**
	 * Returns the identifier of this serializable.
	 * @return the identifier.
	 */
	public String getIdString();
	
	/**
	 * Returns the native {@link String} of this serializable.
	 * @return the native String.
	 */
	public String getNativeString();
	
	/**
	 * Returns the localization {@link String} of this serializable.
	 * @return the localization String.
	 */
	public String getLocalString();
	
}
