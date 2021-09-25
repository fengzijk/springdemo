package com.fengzijk.springdemo.pojo.mongo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Accessors(chain = true)
@Document(collection = "message")
@CompoundIndex(name = "idx_user_send_time", def = "{'user_id': 1, 'send_time': -1}")
public class MongoMessageEntity {


}
