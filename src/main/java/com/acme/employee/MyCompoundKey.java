package com.acme.employee;

import br.ufrgs.engineering.caching.fmwk.CompoundKey;

public class MyCompoundKey extends CompoundKey{

	@Override
	public String compoundKey() {
		
		return "Something really unique and complex";
	}

}
