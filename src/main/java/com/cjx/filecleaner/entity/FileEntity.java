package com.cjx.filecleaner.entity;

import java.util.Date;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

@Table("t_file")
public class FileEntity {
	@Name
	private String id;

	@Column
	private String path;

	@Column
	private long length;

	@Column
	private Date createdate;

	@Column
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public FileEntity() {
	}

	public FileEntity(String id, String path, long length, Date createdate, String status) {
		super();
		this.id = id;
		this.path = path;
		this.length = length;
		this.createdate = createdate;
		this.status = status;
	}
	
	public FileEntity(String id) {
		super();
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "FileEntity [id=" + id + ", path=" + path + ", length=" + length + ", createdate=" + createdate
				+ ", status=" + status + "]";
	}

}
