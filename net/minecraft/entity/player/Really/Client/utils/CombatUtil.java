package net.minecraft.entity.player.Really.Client.utils;

import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class CombatUtil {
   public static float[] getRotations(Entity entity) {
      Minecraft.getMinecraft();
      double pX = Minecraft.thePlayer.posX;
      Minecraft.getMinecraft();
      double var10000 = Minecraft.thePlayer.posY;
      Minecraft.getMinecraft();
      double pY = var10000 + (double)Minecraft.thePlayer.getEyeHeight();
      Minecraft.getMinecraft();
      double pZ = Minecraft.thePlayer.posZ;
      double eX = entity.posX;
      double eY = entity.posY + (double)(entity.height / 2.0F);
      double eZ = entity.posZ;
      double dX = pX - eX;
      double dY = pY - eY;
      double dZ = pZ - eZ;
      double dH = Math.sqrt(Math.pow(dX, 2.0D) + Math.pow(dZ, 2.0D));
      double yaw = Math.toDegrees(Math.atan2(dZ, dX)) + 90.0D;
      double pitch = Math.toDegrees(Math.atan2(dH, dY));
      return new float[]{(float)yaw, (float)(90.0D - pitch)};
   }

   public static float[] getRotationsnull(Entity entity) {
      if(entity == null) {
         return null;
      } else {
         double diffX = entity.posX - Minecraft.thePlayer.posX;
         double diffZ = entity.posZ - Minecraft.thePlayer.posZ;
         double diffY;
         if(entity instanceof EntityLivingBase) {
            EntityLivingBase elb = (EntityLivingBase)entity;
            diffY = elb.posY + ((double)elb.getEyeHeight() - 0.4D) - (Minecraft.thePlayer.posY + (double)Minecraft.thePlayer.getEyeHeight());
         } else {
            diffY = (entity.boundingBox.minY + entity.boundingBox.maxY) / 2.0D - (Minecraft.thePlayer.posY + (double)Minecraft.thePlayer.getEyeHeight());
         }

         double dist = (double)MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
         float yaw = (float)(Math.atan2(diffZ, diffX) * 180.0D / 3.141592653589793D) - 90.0F;
         float pitch = (float)(-(Math.atan2(diffY, dist) * 180.0D / 3.141592653589793D));
         return new float[]{yaw, pitch};
      }
   }

   public static float[] getRotationFromPosition(double x, double y, double z) {
      Minecraft.getMinecraft();
      double xDiff = x - Minecraft.thePlayer.posX;
      Minecraft.getMinecraft();
      double zDiff = z - Minecraft.thePlayer.posZ;
      Minecraft.getMinecraft();
      double var10000 = y - Minecraft.thePlayer.posY;
      Minecraft.getMinecraft();
      double yDiff = var10000 - (double)Minecraft.thePlayer.getEyeHeight();
      double dist = (double)MathHelper.sqrt_double(xDiff * xDiff + zDiff * zDiff);
      float yaw = (float)(Math.atan2(zDiff, xDiff) * 180.0D / 3.141592653589793D) - 90.0F;
      float pitch = (float)(-(Math.atan2(yDiff, dist) * 180.0D / 3.141592653589793D));
      return new float[]{yaw, pitch};
   }

   public static float[] getRotationsNeededBlock(double x, double y, double z) {
      double var10000 = x + 0.5D;
      Minecraft.getMinecraft();
      double diffX = var10000 - Minecraft.thePlayer.posX;
      var10000 = z + 0.5D;
      Minecraft.getMinecraft();
      double diffZ = var10000 - Minecraft.thePlayer.posZ;
      var10000 = y + 0.5D;
      Minecraft.getMinecraft();
      double var10001 = Minecraft.thePlayer.posY;
      Minecraft.getMinecraft();
      double diffY = var10000 - (var10001 + (double)Minecraft.thePlayer.getEyeHeight());
      double dist = (double)MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
      float yaw = (float)(Math.atan2(diffZ, diffX) * 180.0D / 3.141592653589793D) - 90.0F;
      float pitch = (float)(-(Math.atan2(diffY, dist) * 180.0D / 3.141592653589793D));
      float[] var18 = new float[2];
      Minecraft.getMinecraft();
      float var10003 = Minecraft.thePlayer.rotationYaw;
      Minecraft.getMinecraft();
      var18[0] = var10003 + MathHelper.wrapAngleTo180_float(yaw - Minecraft.thePlayer.rotationYaw);
      Minecraft.getMinecraft();
      var10003 = Minecraft.thePlayer.rotationPitch;
      Minecraft.getMinecraft();
      var18[1] = var10003 + MathHelper.wrapAngleTo180_float(pitch - Minecraft.thePlayer.rotationPitch);
      return var18;
   }

   public static float[] getRotationsNeededBlock(double x, double y, double z, double x1, double y1, double z1) {
      double diffX = x1 + 0.5D - x;
      double diffZ = z1 + 0.5D - z;
      double var10000 = y1 + 0.5D;
      Minecraft.getMinecraft();
      double diffY = var10000 - (y + (double)Minecraft.thePlayer.getEyeHeight());
      double dist = (double)MathHelper.sqrt_double(diffX * diffX + diffZ * diffZ);
      float yaw = (float)(Math.atan2(diffZ, diffX) * 180.0D / 3.141592653589793D) - 90.0F;
      float pitch = (float)(-(Math.atan2(diffY, dist) * 180.0D / 3.141592653589793D));
      return new float[]{yaw, pitch};
   }

   public static float getTrajAngleSolutionLow(float d3, float d1, float velocity) {
      float g = 0.006F;
      float sqrt = velocity * velocity * velocity * velocity - 0.006F * (0.006F * d3 * d3 + 2.0F * d1 * velocity * velocity);
      return (float)Math.toDegrees(Math.atan(((double)(velocity * velocity) - Math.sqrt((double)sqrt)) / (double)(0.006F * d3)));
   }

   public static float getNewAngle(float angle) {
      angle = angle % 360.0F;
      if(angle >= 180.0F) {
         angle -= 360.0F;
      }

      if(angle < -180.0F) {
         angle += 360.0F;
      }

      return angle;
   }

   public static float getDistanceBetweenAngles(float angle1, float angle2) {
      float angle3 = Math.abs(angle1 - angle2) % 360.0F;
      if(angle3 > 180.0F) {
         angle3 = 360.0F - angle3;
      }

      return angle3;
   }

   public static Vec3[] getCorners(AxisAlignedBB box) {
      return new Vec3[]{new Vec3(box.minX, box.minY, box.minZ), new Vec3(box.maxX, box.minY, box.minZ), new Vec3(box.minX, box.maxY, box.minZ), new Vec3(box.minX, box.minY, box.maxZ), new Vec3(box.maxX, box.maxY, box.minZ), new Vec3(box.minX, box.maxY, box.maxZ), new Vec3(box.maxX, box.minY, box.maxZ), new Vec3(box.maxX, box.maxY, box.maxZ)};
   }

   public static AxisAlignedBB getCloserBox(AxisAlignedBB b1, AxisAlignedBB b2) {
      Vec3[] corners;
      for(Vec3 pos : corners = getCorners(b2)) {
         if(isRotationIn(getRotationFromPosition(pos.xCoord, pos.yCoord, pos.zCoord), b1)) {
            return getDistanceToBox(b2) < getDistanceToBox(b1)?b2:b1;
         }
      }

      return b2;
   }

   public static double getDistanceToBox(AxisAlignedBB box) {
      Minecraft.getMinecraft();
      return Minecraft.thePlayer.getDistance((box.minX + box.maxX) / 2.0D, (box.minY + box.maxY) / 2.0D, (box.minZ + box.maxZ) / 2.0D);
   }

   public static boolean isRotationIn(float[] rotation, AxisAlignedBB box) {
      float[] maxRotations = getMaxRotations(box);
      return maxRotations[0] < rotation[0] && maxRotations[2] < rotation[1] && maxRotations[1] > rotation[0] && maxRotations[3] > rotation[1];
   }

   public static float[] getRandomRotationsInBox(AxisAlignedBB box) {
      float[] maxRotations = getMaxRotations(box);
      float yaw = (float)MathHelper.getRandomIntegerInRange(new Random(), maxRotations[0], maxRotations[1]);
      float pitch = (float)MathHelper.getRandomIntegerInRange(new Random(), maxRotations[2], maxRotations[3]);
      return new float[]{yaw, pitch};
   }

   public static float[] getMaxRotations(AxisAlignedBB box) {
      float minYaw = 2.14748365E9F;
      float maxYaw = -2.14748365E9F;
      float minPitch = 2.14748365E9F;
      float maxPitch = -2.14748365E9F;

      Vec3[] corners;
      for(Vec3 pos : corners = getCorners(box)) {
         float[] rot = getRotationFromPosition(pos.xCoord, pos.yCoord, pos.zCoord);
         if(rot[0] < minYaw) {
            minYaw = rot[0];
         }

         if(rot[0] > maxYaw) {
            maxYaw = rot[0];
         }

         if(rot[1] < minPitch) {
            minPitch = rot[1];
         }

         if(rot[1] > maxPitch) {
            maxPitch = rot[1];
         }
      }

      return new float[]{minYaw, maxYaw, minPitch, maxPitch};
   }

   public static AxisAlignedBB expandBox(AxisAlignedBB box, double multiplier) {
      multiplier = 1.0D - multiplier / 100.0D;
      return box.expand((box.maxX - box.minX) * multiplier, 0.12D, (box.maxZ - box.minZ) * multiplier);
   }

   public static AxisAlignedBB contractBox(AxisAlignedBB box, double multiplier) {
      multiplier = 1.0D - multiplier / 100.0D;
      return box.contract((box.maxX - box.minX) * multiplier, 0.12D, (box.maxZ - box.minZ) * multiplier);
   }

   public static float getYawDifference(float current, float target) {
      float rot = (target + 180.0F - current) % 360.0F;
      return rot + (rot > 0.0F?-180.0F:180.0F);
   }

   public static float getPitchDifference(float current, float target) {
      float rot = (target + 90.0F - current) % 180.0F;
      return rot + (rot > 0.0F?-90.0F:90.0F);
   }
}
