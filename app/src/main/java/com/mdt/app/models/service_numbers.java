
package com.mdt.app.models;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class service_numbers
{
  private Date created;
  private String objectId;
  private Integer service_id;
  private Date updated;
  private String ownerId;
  private String phone_number;
  public Date getCreated()
  {
    return created;
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

  public Date getUpdated()
  {
    return updated;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getPhone_number()
  {
    return phone_number;
  }

  public void setPhone_number( String phone_number )
  {
    this.phone_number = phone_number;
  }

                                                    
  public service_numbers save()
  {
    return Backendless.Data.of( service_numbers.class ).save( this );
  }

  public void saveAsync( AsyncCallback<service_numbers> callback )
  {
    Backendless.Data.of( service_numbers.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( service_numbers.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( service_numbers.class ).remove( this, callback );
  }

  public static service_numbers findById( String id )
  {
    return Backendless.Data.of( service_numbers.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<service_numbers> callback )
  {
    Backendless.Data.of( service_numbers.class ).findById( id, callback );
  }

  public static service_numbers findFirst()
  {
    return Backendless.Data.of( service_numbers.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<service_numbers> callback )
  {
    Backendless.Data.of( service_numbers.class ).findFirst( callback );
  }

  public static service_numbers findLast()
  {
    return Backendless.Data.of( service_numbers.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<service_numbers> callback )
  {
    Backendless.Data.of( service_numbers.class ).findLast( callback );
  }

  public static List<service_numbers> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( service_numbers.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<service_numbers>> callback )
  {
    Backendless.Data.of( service_numbers.class ).find( queryBuilder, callback );
  }
}