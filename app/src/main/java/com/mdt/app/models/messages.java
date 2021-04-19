
package com.mdt.app.models;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class messages
{
  private String phone_number;
  private Date created;
  private String title;
  private String ownerId;
  private Date updated;
  private String objectId;
  private Integer service_id;
  private String content;
  private List<message_medias> fk_message_medias;
  public String getPhone_number()
  {
    return phone_number;
  }

  public void setPhone_number( String phone_number )
  {
    this.phone_number = phone_number;
  }

  public Date getCreated()
  {
    return created;
  }

  public String getTitle()
  {
    return title;
  }

  public void setTitle( String title )
  {
    this.title = title;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public Date getUpdated()
  {
    return updated;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public Integer getService_id()
  {
    return service_id;
  }

  public void setService_id( Integer service_id )
  {
    this.service_id = service_id;
  }

  public String getContent()
  {
    return content;
  }

  public void setContent( String content )
  {
    this.content = content;
  }

  public List<message_medias> getFk_message_medias()
  {
    return fk_message_medias;
  }

  public void setFk_message_medias( List<message_medias> fk_message_medias )
  {
    this.fk_message_medias = fk_message_medias;
  }

                                                    
  public messages save()
  {
    return Backendless.Data.of( messages.class ).save( this );
  }

  public void saveAsync( AsyncCallback<messages> callback )
  {
    Backendless.Data.of( messages.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( messages.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( messages.class ).remove( this, callback );
  }

  public static messages findById( String id )
  {
    return Backendless.Data.of( messages.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<messages> callback )
  {
    Backendless.Data.of( messages.class ).findById( id, callback );
  }

  public static messages findFirst()
  {
    return Backendless.Data.of( messages.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<messages> callback )
  {
    Backendless.Data.of( messages.class ).findFirst( callback );
  }

  public static messages findLast()
  {
    return Backendless.Data.of( messages.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<messages> callback )
  {
    Backendless.Data.of( messages.class ).findLast( callback );
  }

  public static List<messages> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( messages.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<messages>> callback )
  {
    Backendless.Data.of( messages.class ).find( queryBuilder, callback );
  }
}