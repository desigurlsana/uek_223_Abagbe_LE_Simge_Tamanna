package ch.noseryoung.uk.businessObject.user.dto;

import ch.noseryoung.uk.businessObject.auction.Auction;
import ch.noseryoung.uk.businessObject.role.Role;
import ch.noseryoung.uk.businessObject.user.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-28T15:54:35+0200",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 13.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User fromDTO(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setUsername( dto.getUsername() );
        user.setPassword( dto.getPassword() );
        Set<Role> set = dto.getRoles();
        if ( set != null ) {
            user.setRoles( new HashSet<Role>( set ) );
        }
        user.setLocked( dto.getLocked() );
        Set<Auction> set1 = dto.getAuctions();
        if ( set1 != null ) {
            user.setAuctions( new ArrayList<Auction>( set1 ) );
        }
        user.setEnabled( dto.getEnabled() );

        return user;
    }

    @Override
    public List<User> fromDTOs(List<UserDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dtos.size() );
        for ( UserDTO userDTO : dtos ) {
            list.add( fromDTO( userDTO ) );
        }

        return list;
    }

    @Override
    public Set<User> fromDTOs(Set<UserDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        Set<User> set = new HashSet<User>( Math.max( (int) ( dtos.size() / .75f ) + 1, 16 ) );
        for ( UserDTO userDTO : dtos ) {
            set.add( fromDTO( userDTO ) );
        }

        return set;
    }

    @Override
    public UserDTO toDTO(User dm) {
        if ( dm == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        List<Auction> list = dm.getAuctions();
        if ( list != null ) {
            userDTO.setAuctions( new HashSet<Auction>( list ) );
        }
        userDTO.setId( dm.getId() );
        userDTO.setUsername( dm.getUsername() );
        userDTO.setPassword( dm.getPassword() );
        Set<Role> set = dm.getRoles();
        if ( set != null ) {
            userDTO.setRoles( new HashSet<Role>( set ) );
        }
        userDTO.setLocked( dm.getLocked() );
        userDTO.setEnabled( dm.getEnabled() );

        return userDTO;
    }

    @Override
    public List<UserDTO> toDTOs(List<User> dms) {
        if ( dms == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( dms.size() );
        for ( User user : dms ) {
            list.add( toDTO( user ) );
        }

        return list;
    }

    @Override
    public Set<UserDTO> toDTOs(Set<User> dms) {
        if ( dms == null ) {
            return null;
        }

        Set<UserDTO> set = new HashSet<UserDTO>( Math.max( (int) ( dms.size() / .75f ) + 1, 16 ) );
        for ( User user : dms ) {
            set.add( toDTO( user ) );
        }

        return set;
    }
}
