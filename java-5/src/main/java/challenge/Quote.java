package challenge;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "scripts")
public class Quote {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String actor;
	
	@Column(name = "detail")
	private String quote;
	
	@Column
	private Integer episode;
	
	@Column
	private String episodeName;
	
	@Column
	private String segment;
	
	@Column
	private String type;

	@Column
	private String character;
	
	@Column
	private String recordDate;
	
	@Column
	private String series;
	
	@Column
	private String transmissionDate;
	
	public Quote() {}

	public Quote(Integer id, String actor, String quote, Integer episode, String episodeName, String segment,
			String type, String character, String recordDate, String series, String transmissionDate) {
		super();
		this.id = id;
		this.actor = actor;
		this.quote = quote;
		this.episode = episode;
		this.episodeName = episodeName;
		this.segment = segment;
		this.type = type;
		this.character = character;
		this.recordDate = recordDate;
		this.series = series;
		this.transmissionDate = transmissionDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public Integer getEpisode() {
		return episode;
	}

	public void setEpisode(Integer episode) {
		this.episode = episode;
	}

	public String getEpisodeName() {
		return episodeName;
	}

	public void setEpisodeName(String episodeName) {
		this.episodeName = episodeName;
	}

	public String getSegment() {
		return segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getTransmissionDate() {
		return transmissionDate;
	}

	public void setTransmissionDate(String transmissionDate) {
		this.transmissionDate = transmissionDate;
	}

}
