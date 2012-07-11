/*
 * This file is part of PermissionsGuru. PermissionsGuru is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any later version. PermissionsGuru is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with PermissionsGuru. If not, see <http://www.gnu.org/licenses/>.
 */
package sk.tomsik68.permsguru;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public enum EPermissions {
	None(new PermissionService(){

		@Override
		public boolean hasPermission(CommandSender player, String node) {
			return true;
		}
	}),
	OP(new PermissionService(){
		@Override
		public boolean hasPermission(CommandSender player, String node) {
			return player.isOp();
		}
	}),
	SP(new PermissionService(){

		@Override
		public boolean hasPermission(CommandSender player, String node) {
			return player.hasPermission(node);
		}
	});
	private final PermissionService p;
	private EPermissions(PermissionService ps){
		p = ps;
	}
	public boolean has(CommandSender sender,String node){
		return sender.hasPermission(node);
	}
	public static EPermissions parse(String str){
	    EPermissions result = EPermissions.None;
	    try{
	        result = EPermissions.valueOf(str);
	    }catch(Exception e){
	        try{
	            result = EPermissions.valueOf(str.toUpperCase());
	        }catch(Exception e1){
	            Plugin[] plugins = Bukkit.getServer().getPluginManager().getPlugins();
	            for(Plugin plugin : plugins){
	                if(plugin.getName().contains("permissions")){
	                    result = EPermissions.SP;
	                }
	            }
	        }
	    }
        return result;
	}
}
