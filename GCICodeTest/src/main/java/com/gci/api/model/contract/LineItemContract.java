package com.gci.api.model.contract;

import java.util.ArrayList;
import java.util.List;

import com.gci.api.model.LineItem;

public class LineItemContract extends AbstractBaseContract {

	private List<LineItem> lineItems = new ArrayList<LineItem>(50);

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	@Override
	public ContractType getType() {
		return ContractType.LINE_ITEM;
	}

}
