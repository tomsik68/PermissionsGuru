/*
 * This file is part of PermissionsGuru. PermissionsGuru is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any later version. PermissionsGuru is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details. You should have received
 * a copy of the GNU General Public License along with PermissionsGuru. If not, see <http://www.gnu.org/licenses/>.
 */
package sk.tomsik68.permsguru;

import org.bukkit.command.CommandSender;

public interface PermissionService {
	public boolean hasPermission(CommandSender sender,String node);
}
