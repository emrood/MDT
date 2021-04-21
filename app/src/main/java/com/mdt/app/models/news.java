
package com.mdt.app.models;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Date;

public class news implements Serializable
{
  private String ownerId;
  private String content;
  private String objectId;
  private Date created;
  private String title;
  private Date updated;
  private List<new_medias> fk_news_media;
  public String getOwnerId()
  {
    return ownerId;
  }

  public String getContent()
  {
    return content;
  }

  public void setContent( String content )
  {
    this.content = content;
  }

  public String getObjectId()
  {
    return objectId;
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

  public Date getUpdated()
  {
    return updated;
  }

  public List<new_medias> getFk_news_media()
  {
    return fk_news_media;
  }

  public void setFk_news_media( List<new_medias> fk_news_media )
  {
    this.fk_news_media = fk_news_media;
  }

                                                    
  public news save()
  {
    return Backendless.Data.of( news.class ).save( this );
  }

  public void saveAsync( AsyncCallback<news> callback )
  {
    Backendless.Data.of( news.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( news.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( news.class ).remove( this, callback );
  }

  public static news findById( String id )
  {
    return Backendless.Data.of( news.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<news> callback )
  {
    Backendless.Data.of( news.class ).findById( id, callback );
  }

  public static news findFirst()
  {
    return Backendless.Data.of( news.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<news> callback )
  {
    Backendless.Data.of( news.class ).findFirst( callback );
  }

  public static news findLast()
  {
    return Backendless.Data.of( news.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<news> callback )
  {
    Backendless.Data.of( news.class ).findLast( callback );
  }

  public static List<news> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( news.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<news>> callback )
  {
    Backendless.Data.of( news.class ).find( queryBuilder, callback );
  }
}