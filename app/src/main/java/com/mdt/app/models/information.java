
package com.mdt.app.models;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class information
{
  private String ownerId;
  private String objectId;
  private String work_phone;
  private String urgent_phone;
  private String address;
  private String name;
  private Date updated;
  private String logo_path;
  private Date created;
  public String getOwnerId()
  {
    return ownerId;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getWork_phone()
  {
    return work_phone;
  }

  public void setWork_phone( String work_phone )
  {
    this.work_phone = work_phone;
  }

  public String getUrgent_phone()
  {
    return urgent_phone;
  }

  public void setUrgent_phone( String urgent_phone )
  {
    this.urgent_phone = urgent_phone;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress( String address )
  {
    this.address = address;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public Date getUpdated()
  {
    return updated;
  }

  public String getLogo_path()
  {
    return logo_path;
  }

  public void setLogo_path( String logo_path )
  {
    this.logo_path = logo_path;
  }

  public Date getCreated()
  {
    return created;
  }

                                                    
  public information save()
  {
    return Backendless.Data.of( information.class ).save( this );
  }

  public void saveAsync( AsyncCallback<information> callback )
  {
    Backendless.Data.of( information.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( information.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( information.class ).remove( this, callback );
  }

  public static information findById( String id )
  {
    return Backendless.Data.of( information.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<information> callback )
  {
    Backendless.Data.of( information.class ).findById( id, callback );
  }

  public static information findFirst()
  {
    return Backendless.Data.of( information.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<information> callback )
  {
    Backendless.Data.of( information.class ).findFirst( callback );
  }

  public static information findLast()
  {
    return Backendless.Data.of( information.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<information> callback )
  {
    Backendless.Data.of( information.class ).findLast( callback );
  }

  public static List<information> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( information.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<information>> callback )
  {
    Backendless.Data.of( information.class ).find( queryBuilder, callback );
  }
}