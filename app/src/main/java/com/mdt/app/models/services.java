
package com.mdt.app.models;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class services
{
  private String email;
  private String objectId;
  private Date created;
  private String address;
  private String ownerId;
  private Date updated;
  private String name;
  private String image_path;
  private List<service_numbers> fk_services_numbers;
  public String getEmail()
  {
    return email;
  }

  public void setEmail( String email )
  {
    this.email = email;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public Date getCreated()
  {
    return created;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress( String address )
  {
    this.address = address;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public Date getUpdated()
  {
    return updated;
  }

  public String getName()
  {
    return name;
  }

  public String getImage_path() {
    return image_path;
  }

  public void setImage_path(String image_path) {
    this.image_path = image_path;
  }

  public void setName(String name )
  {
    this.name = name;
  }

  public List<service_numbers> getFk_services_numbers()
  {
    return fk_services_numbers;
  }

  public void setFk_services_numbers( List<service_numbers> fk_services_numbers )
  {
    this.fk_services_numbers = fk_services_numbers;
  }

                                                    
  public services save()
  {
    return Backendless.Data.of( services.class ).save( this );
  }

  public void saveAsync( AsyncCallback<services> callback )
  {
    Backendless.Data.of( services.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( services.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( services.class ).remove( this, callback );
  }

  public static services findById( String id )
  {
    return Backendless.Data.of( services.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<services> callback )
  {
    Backendless.Data.of( services.class ).findById( id, callback );
  }

  public static services findFirst()
  {
    return Backendless.Data.of( services.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<services> callback )
  {
    Backendless.Data.of( services.class ).findFirst( callback );
  }

  public static services findLast()
  {
    return Backendless.Data.of( services.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<services> callback )
  {
    Backendless.Data.of( services.class ).findLast( callback );
  }

  public static List<services> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( services.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<services>> callback )
  {
    Backendless.Data.of( services.class ).find( queryBuilder, callback );
  }
}