package example.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Manager(
  @Id
  val id :ObjectId = ObjectId.get(),
  val first_name :String,
  val last_name :String
)
