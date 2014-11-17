package models;

import javax.persistence.*;

import com.thoughtworks.xstream.mapper.Mapper.Null;

import play.libs.Codec;
import play.db.jpa.GenericModel;

@Entity
@Table (name = "person")
public class Person extends GenericModel{
	@Id
	public String id;
	
	@Column (name = "person_name")
	public String name;
	
	@Lob
	@Column (name = "sex")
	public String sex;
	
	@Column (name = "age")
	public Integer age;
	
	@Column (name = "height")
	public String height;
	
	@Column (name = "weight")
	public String weight;
	
	public Person()
	{
		id = Codec.UUID().replace("-", "").toUpperCase();
	}
	
	public void addperson(String name ,String sex)
	{
		if( Person.find("name = ? And sex = ?", name ,sex).first()==null)
		{
		Person person = new Person();
		person.name = name;
		person.sex = sex;
		person.save();
		}
	}
}
