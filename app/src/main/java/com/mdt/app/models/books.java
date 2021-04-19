
package com.mdt.app.models;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class books
{
  private String name;
  private String image_path;
  private String author;
  private String ownerId;
  private Date updated;
  private Date created;
  private Integer edition_id;
  private String objectId;
  private String summary;
  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public String getImage_path()
  {
    return image_path;
  }

  public void setImage_path( String image_path )
  {
    this.image_path = image_path;
  }

  public String getAuthor()
  {
    return author;
  }

  public void setAuthor( String author )
  {
    this.author = author;
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

  public Integer getEdition_id()
  {
    return edition_id;
  }

  public void setEdition_id( Integer edition_id )
  {
    this.edition_id = edition_id;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getSummary()
  {
    return summary;
  }

  public void setSummary( String summary )
  {
    this.summary = summary;
  }

                                                    
  public books save()
  {
    return Backendless.Data.of( books.class ).save( this );
  }

  public void saveAsync( AsyncCallback<books> callback )
  {
    Backendless.Data.of( books.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( books.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( books.class ).remove( this, callback );
  }

  public static books findById( String id )
  {
    return Backendless.Data.of( books.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<books> callback )
  {
    Backendless.Data.of( books.class ).findById( id, callback );
  }

  public static books findFirst()
  {
    return Backendless.Data.of( books.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<books> callback )
  {
    Backendless.Data.of( books.class ).findFirst( callback );
  }

  public static books findLast()
  {
    return Backendless.Data.of( books.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<books> callback )
  {
    Backendless.Data.of( books.class ).findLast( callback );
  }

  public static List<books> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( books.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<books>> callback )
  {
    Backendless.Data.of( books.class ).find( queryBuilder, callback );
  }
}