
package com.mdt.app.models;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class message_medias
{
  private String media_type;
  private String path;
  private Integer message_id;
  private String objectId;
  private String ownerId;
  private Date updated;
  private Date created;
  public String getMedia_type()
  {
    return media_type;
  }

  public void setMedia_type( String media_type )
  {
    this.media_type = media_type;
  }

  public String getPath()
  {
    return path;
  }

  public void setPath( String path )
  {
    this.path = path;
  }

  public Integer getMessage_id()
  {
    return message_id;
  }

  public void setMessage_id( Integer message_id )
  {
    this.message_id = message_id;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public Date getUpdated()
  {
    return updated;
  }

  public Date getCreated()
  {
    return created;
  }

                                                    
  public message_medias save()
  {
    return Backendless.Data.of( message_medias.class ).save( this );
  }

  public void saveAsync( AsyncCallback<message_medias> callback )
  {
    Backendless.Data.of( message_medias.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( message_medias.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( message_medias.class ).remove( this, callback );
  }

  public static message_medias findById( String id )
  {
    return Backendless.Data.of( message_medias.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<message_medias> callback )
  {
    Backendless.Data.of( message_medias.class ).findById( id, callback );
  }

  public static message_medias findFirst()
  {
    return Backendless.Data.of( message_medias.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<message_medias> callback )
  {
    Backendless.Data.of( message_medias.class ).findFirst( callback );
  }

  public static message_medias findLast()
  {
    return Backendless.Data.of( message_medias.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<message_medias> callback )
  {
    Backendless.Data.of( message_medias.class ).findLast( callback );
  }

  public static List<message_medias> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( message_medias.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<message_medias>> callback )
  {
    Backendless.Data.of( message_medias.class ).find( queryBuilder, callback );
  }
}