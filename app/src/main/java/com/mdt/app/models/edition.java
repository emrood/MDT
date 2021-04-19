
package com.mdt.app.models;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class edition
{
  private String name;
  private String ownerId;
  private Date updated;
  private Date created;
  private String objectId;
  private List<books> fk_edition_books;
  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
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

  public String getObjectId()
  {
    return objectId;
  }

  public List<books> getFk_edition_books()
  {
    return fk_edition_books;
  }

  public void setFk_edition_books( List<books> fk_edition_books )
  {
    this.fk_edition_books = fk_edition_books;
  }

                                                    
  public edition save()
  {
    return Backendless.Data.of( edition.class ).save( this );
  }

  public void saveAsync( AsyncCallback<edition> callback )
  {
    Backendless.Data.of( edition.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( edition.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( edition.class ).remove( this, callback );
  }

  public static edition findById( String id )
  {
    return Backendless.Data.of( edition.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<edition> callback )
  {
    Backendless.Data.of( edition.class ).findById( id, callback );
  }

  public static edition findFirst()
  {
    return Backendless.Data.of( edition.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<edition> callback )
  {
    Backendless.Data.of( edition.class ).findFirst( callback );
  }

  public static edition findLast()
  {
    return Backendless.Data.of( edition.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<edition> callback )
  {
    Backendless.Data.of( edition.class ).findLast( callback );
  }

  public static List<edition> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( edition.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<edition>> callback )
  {
    Backendless.Data.of( edition.class ).find( queryBuilder, callback );
  }
}