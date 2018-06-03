package com.oracle.model.bean;
import java.io.Serializable;

/**
 * 新闻信息�? 儌僨儖僋儔僗.
 * 
 * @author generated by ERMaster
 * @version $Id$
 */
public class New implements Serializable {

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** 新闻编号. */
	private Integer newid;

	/** 新闻标题. */
	private String biaoti;

	/** 新闻内容. */
	private String neirong;

	/** 发布时间. */
	private String fabushijian;

	/** 发布�?. */
	private String faburen;

	/** 新闻配图. */
	private String xinwenpeitu;

	/** 阅读�?. */
	private Integer yueduliang;

	/**
	 * 僐儞僗僩儔僋�?.
	 */
	public New() {
	}


	/**
	 * 新闻标题 傪愝掕偟傑偡.
	 * 
	 * @param biaoti
	 *            新闻标题
	 */
	public void setBiaoti(String biaoti) {
		this.biaoti = biaoti;
	}

	/**
	 * 新闻标题 傪庢摼偟傑偡.
	 * 
	 * @return 新闻标题
	 */
	public String getBiaoti() {
		return this.biaoti;
	}

	/**
	 * 新闻内容 傪愝掕偟傑偡.
	 * 
	 * @param neirong
	 *            新闻内容
	 */
	public void setNeirong(String neirong) {
		this.neirong = neirong;
	}

	/**
	 * 新闻内容 傪庢摼偟傑偡.
	 * 
	 * @return 新闻内容
	 */
	public String getNeirong() {
		return this.neirong;
	}

	/**
	 * 发布时间 傪愝掕偟傑偡.
	 * 
	 * @param fabushijian
	 *            发布时间
	 */
	public void setFabushijian(String fabushijian) {
		this.fabushijian = fabushijian;
	}

	/**
	 * 发布时间 傪庢摼偟傑偡.
	 * 
	 * @return 发布时间
	 */
	public String getFabushijian() {
		return this.fabushijian;
	}

	/**
	 * 发布�? 傪愝掕偟傑偡.
	 * 
	 * @param faburen
	 *            发布�?
	 */
	public void setFaburen(String faburen) {
		this.faburen = faburen;
	}

	/**
	 * 发布�? 傪庢摼偟傑偡.
	 * 
	 * @return 发布�?
	 */
	public String getFaburen() {
		return this.faburen;
	}

	/**
	 * 新闻配图 傪愝掕偟傑偡.
	 * 
	 * @param xinwenpeitu
	 *            新闻配图
	 */
	public void setXinwenpeitu(String xinwenpeitu) {
		this.xinwenpeitu = xinwenpeitu;
	}

	/**
	 * 新闻配图 傪庢摼偟傑偡.
	 * 
	 * @return 新闻配图
	 */
	public String getXinwenpeitu() {
		return this.xinwenpeitu;
	}

	/**
	 * 阅读�? 傪愝掕偟傑偡.
	 * 
	 * @param yueduliang
	 *            阅读�?
	 */
	public void setYueduliang(Integer yueduliang) {
		this.yueduliang = yueduliang;
	}

	/**
	 * 阅读�? 傪庢摼偟傑偡.
	 * 
	 * @return 阅读�?
	 */
	public Integer getYueduliang() {
		return this.yueduliang;
	}


	public Integer getNewid() {
		return newid;
	}


	public void setNewid(Integer newid) {
		this.newid = newid;
	}


	@Override
	public String toString() {
		return "New [newid=" + newid + ", biaoti=" + biaoti + ", neirong=" + neirong + ", fabushijian=" + fabushijian
				+ ", faburen=" + faburen + ", xinwenpeitu=" + xinwenpeitu + ", yueduliang=" + yueduliang + "]";
	}


}
