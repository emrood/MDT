
package com.mdt.app.models;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class new_medias
{
  private String media_type;
  private String ownerId;
  private Date created;
  private String objectId;
  private Date updated;
  private String path;
  private String new_id;
  public String getMedia_type()
  {
    return media_type;
  }

  public void setMedia_type( String media_type )
  {
    this.media_type = media_type;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public Date getCreated()
  {
    return created;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public Date getUpdated()
  {
    return updated;
  }

  public String getPath()
  {
    return path;
  }

  public void setPath( String path )
  {
    this.path = path;
  }

  public String getNew_id()
  {
    return new_id;
  }

  public void setNew_id( String new_id )
  {
    this.new_id = new_id;
  }

                                                    
  public new_medias save()
  {
    return Backendless.Data.of( new_medias.class ).save( this );
  }

  public void saveAsync( AsyncCallback<new_medias> callback )
  {
    Backendless.Data.of( new_medias.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( new_medias.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( new_medias.class ).remove( this, callback );
  }

  public static new_medias findById( String id )
  {
    return Backendless.Data.of( new_medias.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<new_medias> callback )
  {
    Backendless.Data.of( new_medias.class ).findById( id, callback );
  }

  public static new_medias findFirst()
  {
    return Backendless.Data.of( new_medias.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<new_medias> callback )
  {
    Backendless.Data.of( new_medias.class ).findFirst( callback );
  }

  public static new_medias findLast()
  {
    return Backendless.Data.of( new_medias.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<new_medias> callback )
  {
    Backendless.Data.of( new_medias.class ).findLast( callback );
  }

  public static List<new_medias> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( new_medias.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<new_medias>> callback )
  {
    Backendless.Data.of( new_medias.class ).find( queryBuilder, callback );
  }
}