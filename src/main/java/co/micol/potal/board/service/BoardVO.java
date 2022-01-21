package co.micol.potal.board.service;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;



@Data

public class BoardVO {
	private String cot_id;
	private String content_id;
	private String title;
	private String img_id;
	private Date event_start_date;
	private Date event_end_date;
	private int read_count;
	private String oview;
	private String addr;
	private String homepage;
}
