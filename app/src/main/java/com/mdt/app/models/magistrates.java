
package com.mdt.app.models;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;

import java.util.List;
import java.util.Date;

public class magistrates
{
  private String address;
  private String email;
  private String mobile_phone;
  private String work_phone;
  private String picture_path;
  private Boolean status;
  private String objectId;
  private String ownerId;
  private Date created;
  private Integer position;
  private String name;
  private Date updated;
  public String getAddress()
  {
    return address;
  }

  public void setAddress( String address )
  {
    this.address = address;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail( String email )
  {
    this.email = email;
  }

  public String getMobile_phone()
  {
    return mobile_phone;
  }

  public void setMobile_phone( String mobile_phone )
  {
    this.mobile_phone = mobile_phone;
  }

  public String getWork_phone()
  {
    return work_phone;
  }

  public void setWork_phone( String work_phone )
  {
    this.work_phone = work_phone;
  }

  public String getPicture_path()
  {
    return picture_path;
  }

  public void setPicture_path( String picture_path )
  {
    this.picture_path = picture_path;
  }

  public Boolean getStatus()
  {
    return status;
  }

  public void setStatus( Boolean status )
  {
    this.status = status;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public Date getCreated()
  {
    return created;
  }

  public Integer getPosition()
  {
    return position;
  }

  public void setPosition( Integer position )
  {
    this.position = position;
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

                                                    
  public magistrates save()
  {
    return Backendless.Data.of( magistrates.class ).save( this );
  }

  public void saveAsync( AsyncCallback<magistrates> callback )
  {
    Backendless.Data.of( magistrates.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( magistrates.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( magistrates.class ).remove( this, callback );
  }

  public static magistrates findById( String id )
  {
    return Backendless.Data.of( magistrates.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<magistrates> callback )
  {
    Backendless.Data.of( magistrates.class ).findById( id, callback );
  }

  public static magistrates findFirst()
  {
    return Backendless.Data.of( magistrates.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<magistrates> callback )
  {
    Backendless.Data.of( magistrates.class ).findFirst( callback );
  }

  public static magistrates findLast()
  {
    return Backendless.Data.of( magistrates.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<magistrates> callback )
  {
    Backendless.Data.of( magistrates.class ).findLast( callback );
  }

  public static List<magistrates> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( magistrates.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<magistrates>> callback )
  {
    Backendless.Data.of( magistrates.class ).find( queryBuilder, callback );
  }
}