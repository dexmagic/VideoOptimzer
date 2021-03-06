/*
 *  Copyright 2014 AT&T
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
*/
package com.att.aro.core.bestpractice.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class MinificationResult extends AbstractBestPracticeResult {
	private List<MinificationEntry> minificationEntryList = null;
	private int totalSavingsInByte = 0;
	private long totalSavingsInKb = 0L;
	@JsonIgnore
	private String exportAllNumberOfMinifyFiles;
	
	@Override
	public BestPracticeType getBestPracticeType() {
		return BestPracticeType.MINIFICATION;
	}

	public List<MinificationEntry> getMinificationEntryList() {
		return minificationEntryList;
	}

	public void setMinificationEntryList(
			List<MinificationEntry> minificationEntryList) {
		this.minificationEntryList = minificationEntryList;
	}

	public long getTotalSavingsInKb() {
		return totalSavingsInKb;
	}

	public void setTotalSavingsInKb(long totalSavingsInKb) {
		this.totalSavingsInKb = totalSavingsInKb;
	}
	public int getNumberOfMinifyFiles() {
		if(minificationEntryList != null){
			return minificationEntryList.size();
		}
		return 0;
	}

	public int getTotalSavingsInByte() {
		return totalSavingsInByte;
	}

	public void setTotalSavingsInByte(int totalSavingsInByte) {
		this.totalSavingsInByte = totalSavingsInByte;
	}

	public String getExportAllNumberOfMinifyFiles() {
		return exportAllNumberOfMinifyFiles;
	}

	public void setExportAllNumberOfMinifyFiles(String exportAllNumberOfMinifyFiles) {
		this.exportAllNumberOfMinifyFiles = exportAllNumberOfMinifyFiles;
	}
	
	public int getErrorCount() {
		return minificationEntryList != null ? minificationEntryList.size() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		MinificationResult other = (MinificationResult) obj;
		if (other.getTotalSavingsInByte() != totalSavingsInByte || other.getTotalSavingsInKb() != totalSavingsInKb) {
			return false;
		}
		if (!other.getMinificationEntryList().containsAll(minificationEntryList)) {
			return false;
		}
		if ((!other.getBestPracticeDescription().trim().equals(getBestPracticeDescription().trim()))
				|| getResultType() != other.getResultType()) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + totalSavingsInByte;
		result = prime * result + (int) totalSavingsInKb;
		for (MinificationEntry entry : minificationEntryList) {
			result = prime * result + entry.hashCode();
		}
		result = prime * result + getBestPracticeDescription().hashCode();
		result = prime * result + getBestPracticeType().hashCode();
		return result;
	}
}
