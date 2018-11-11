package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_example_hellcat_pac1_model_BookItemRealmProxy extends com.example.hellcat.pac1.model.BookItem
    implements RealmObjectProxy, com_example_hellcat_pac1_model_BookItemRealmProxyInterface {

    static final class BookItemColumnInfo extends ColumnInfo {
        long identificadorIndex;
        long tituloIndex;
        long autorIndex;
        long fechaIndex;
        long descripcionIndex;
        long urlIndex;

        BookItemColumnInfo(OsSchemaInfo schemaInfo) {
            super(6);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("BookItem");
            this.identificadorIndex = addColumnDetails("identificador", "identificador", objectSchemaInfo);
            this.tituloIndex = addColumnDetails("titulo", "titulo", objectSchemaInfo);
            this.autorIndex = addColumnDetails("autor", "autor", objectSchemaInfo);
            this.fechaIndex = addColumnDetails("fecha", "fecha", objectSchemaInfo);
            this.descripcionIndex = addColumnDetails("descripcion", "descripcion", objectSchemaInfo);
            this.urlIndex = addColumnDetails("url", "url", objectSchemaInfo);
        }

        BookItemColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BookItemColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BookItemColumnInfo src = (BookItemColumnInfo) rawSrc;
            final BookItemColumnInfo dst = (BookItemColumnInfo) rawDst;
            dst.identificadorIndex = src.identificadorIndex;
            dst.tituloIndex = src.tituloIndex;
            dst.autorIndex = src.autorIndex;
            dst.fechaIndex = src.fechaIndex;
            dst.descripcionIndex = src.descripcionIndex;
            dst.urlIndex = src.urlIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private BookItemColumnInfo columnInfo;
    private ProxyState<com.example.hellcat.pac1.model.BookItem> proxyState;

    com_example_hellcat_pac1_model_BookItemRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BookItemColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.example.hellcat.pac1.model.BookItem>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public Integer realmGet$identificador() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.identificadorIndex)) {
            return null;
        }
        return (int) proxyState.getRow$realm().getLong(columnInfo.identificadorIndex);
    }

    @Override
    public void realmSet$identificador(Integer value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.identificadorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setLong(columnInfo.identificadorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.identificadorIndex);
            return;
        }
        proxyState.getRow$realm().setLong(columnInfo.identificadorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$titulo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.tituloIndex);
    }

    @Override
    public void realmSet$titulo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.tituloIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.tituloIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.tituloIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.tituloIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$autor() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.autorIndex);
    }

    @Override
    public void realmSet$autor(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.autorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.autorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.autorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.autorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$fecha() {
        proxyState.getRealm$realm().checkIfValid();
        if (proxyState.getRow$realm().isNull(columnInfo.fechaIndex)) {
            return null;
        }
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.fechaIndex);
    }

    @Override
    public void realmSet$fecha(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fechaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setDate(columnInfo.fechaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fechaIndex);
            return;
        }
        proxyState.getRow$realm().setDate(columnInfo.fechaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$descripcion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descripcionIndex);
    }

    @Override
    public void realmSet$descripcion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descripcionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descripcionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descripcionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descripcionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$url() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.urlIndex);
    }

    @Override
    public void realmSet$url(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.urlIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.urlIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.urlIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.urlIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("BookItem", 6, 0);
        builder.addPersistedProperty("identificador", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("titulo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("autor", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fecha", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("descripcion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("url", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static BookItemColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new BookItemColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "BookItem";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "BookItem";
    }

    @SuppressWarnings("cast")
    public static com.example.hellcat.pac1.model.BookItem createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.hellcat.pac1.model.BookItem obj = realm.createObjectInternal(com.example.hellcat.pac1.model.BookItem.class, true, excludeFields);

        final com_example_hellcat_pac1_model_BookItemRealmProxyInterface objProxy = (com_example_hellcat_pac1_model_BookItemRealmProxyInterface) obj;
        if (json.has("identificador")) {
            if (json.isNull("identificador")) {
                objProxy.realmSet$identificador(null);
            } else {
                objProxy.realmSet$identificador((int) json.getInt("identificador"));
            }
        }
        if (json.has("titulo")) {
            if (json.isNull("titulo")) {
                objProxy.realmSet$titulo(null);
            } else {
                objProxy.realmSet$titulo((String) json.getString("titulo"));
            }
        }
        if (json.has("autor")) {
            if (json.isNull("autor")) {
                objProxy.realmSet$autor(null);
            } else {
                objProxy.realmSet$autor((String) json.getString("autor"));
            }
        }
        if (json.has("fecha")) {
            if (json.isNull("fecha")) {
                objProxy.realmSet$fecha(null);
            } else {
                Object timestamp = json.get("fecha");
                if (timestamp instanceof String) {
                    objProxy.realmSet$fecha(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$fecha(new Date(json.getLong("fecha")));
                }
            }
        }
        if (json.has("descripcion")) {
            if (json.isNull("descripcion")) {
                objProxy.realmSet$descripcion(null);
            } else {
                objProxy.realmSet$descripcion((String) json.getString("descripcion"));
            }
        }
        if (json.has("url")) {
            if (json.isNull("url")) {
                objProxy.realmSet$url(null);
            } else {
                objProxy.realmSet$url((String) json.getString("url"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.hellcat.pac1.model.BookItem createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.example.hellcat.pac1.model.BookItem obj = new com.example.hellcat.pac1.model.BookItem();
        final com_example_hellcat_pac1_model_BookItemRealmProxyInterface objProxy = (com_example_hellcat_pac1_model_BookItemRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("identificador")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$identificador((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$identificador(null);
                }
            } else if (name.equals("titulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$titulo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$titulo(null);
                }
            } else if (name.equals("autor")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$autor((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$autor(null);
                }
            } else if (name.equals("fecha")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$fecha(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$fecha(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$fecha(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("descripcion")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$descripcion((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$descripcion(null);
                }
            } else if (name.equals("url")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$url((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$url(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.example.hellcat.pac1.model.BookItem copyOrUpdate(Realm realm, com.example.hellcat.pac1.model.BookItem object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.hellcat.pac1.model.BookItem) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.example.hellcat.pac1.model.BookItem copy(Realm realm, com.example.hellcat.pac1.model.BookItem newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.hellcat.pac1.model.BookItem) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.example.hellcat.pac1.model.BookItem realmObject = realm.createObjectInternal(com.example.hellcat.pac1.model.BookItem.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        com_example_hellcat_pac1_model_BookItemRealmProxyInterface realmObjectSource = (com_example_hellcat_pac1_model_BookItemRealmProxyInterface) newObject;
        com_example_hellcat_pac1_model_BookItemRealmProxyInterface realmObjectCopy = (com_example_hellcat_pac1_model_BookItemRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$identificador(realmObjectSource.realmGet$identificador());
        realmObjectCopy.realmSet$titulo(realmObjectSource.realmGet$titulo());
        realmObjectCopy.realmSet$autor(realmObjectSource.realmGet$autor());
        realmObjectCopy.realmSet$fecha(realmObjectSource.realmGet$fecha());
        realmObjectCopy.realmSet$descripcion(realmObjectSource.realmGet$descripcion());
        realmObjectCopy.realmSet$url(realmObjectSource.realmGet$url());
        return realmObject;
    }

    public static long insert(Realm realm, com.example.hellcat.pac1.model.BookItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.hellcat.pac1.model.BookItem.class);
        long tableNativePtr = table.getNativePtr();
        BookItemColumnInfo columnInfo = (BookItemColumnInfo) realm.getSchema().getColumnInfo(com.example.hellcat.pac1.model.BookItem.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Number realmGet$identificador = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$identificador();
        if (realmGet$identificador != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.identificadorIndex, rowIndex, realmGet$identificador.longValue(), false);
        }
        String realmGet$titulo = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$titulo();
        if (realmGet$titulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tituloIndex, rowIndex, realmGet$titulo, false);
        }
        String realmGet$autor = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$autor();
        if (realmGet$autor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.autorIndex, rowIndex, realmGet$autor, false);
        }
        java.util.Date realmGet$fecha = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha.getTime(), false);
        }
        String realmGet$descripcion = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$descripcion();
        if (realmGet$descripcion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
        }
        String realmGet$url = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.hellcat.pac1.model.BookItem.class);
        long tableNativePtr = table.getNativePtr();
        BookItemColumnInfo columnInfo = (BookItemColumnInfo) realm.getSchema().getColumnInfo(com.example.hellcat.pac1.model.BookItem.class);
        com.example.hellcat.pac1.model.BookItem object = null;
        while (objects.hasNext()) {
            object = (com.example.hellcat.pac1.model.BookItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Number realmGet$identificador = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$identificador();
            if (realmGet$identificador != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.identificadorIndex, rowIndex, realmGet$identificador.longValue(), false);
            }
            String realmGet$titulo = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$titulo();
            if (realmGet$titulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tituloIndex, rowIndex, realmGet$titulo, false);
            }
            String realmGet$autor = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$autor();
            if (realmGet$autor != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.autorIndex, rowIndex, realmGet$autor, false);
            }
            java.util.Date realmGet$fecha = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$fecha();
            if (realmGet$fecha != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha.getTime(), false);
            }
            String realmGet$descripcion = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$descripcion();
            if (realmGet$descripcion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
            }
            String realmGet$url = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$url();
            if (realmGet$url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.hellcat.pac1.model.BookItem object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.hellcat.pac1.model.BookItem.class);
        long tableNativePtr = table.getNativePtr();
        BookItemColumnInfo columnInfo = (BookItemColumnInfo) realm.getSchema().getColumnInfo(com.example.hellcat.pac1.model.BookItem.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Number realmGet$identificador = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$identificador();
        if (realmGet$identificador != null) {
            Table.nativeSetLong(tableNativePtr, columnInfo.identificadorIndex, rowIndex, realmGet$identificador.longValue(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.identificadorIndex, rowIndex, false);
        }
        String realmGet$titulo = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$titulo();
        if (realmGet$titulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.tituloIndex, rowIndex, realmGet$titulo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.tituloIndex, rowIndex, false);
        }
        String realmGet$autor = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$autor();
        if (realmGet$autor != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.autorIndex, rowIndex, realmGet$autor, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.autorIndex, rowIndex, false);
        }
        java.util.Date realmGet$fecha = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$fecha();
        if (realmGet$fecha != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fechaIndex, rowIndex, false);
        }
        String realmGet$descripcion = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$descripcion();
        if (realmGet$descripcion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descripcionIndex, rowIndex, false);
        }
        String realmGet$url = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$url();
        if (realmGet$url != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.hellcat.pac1.model.BookItem.class);
        long tableNativePtr = table.getNativePtr();
        BookItemColumnInfo columnInfo = (BookItemColumnInfo) realm.getSchema().getColumnInfo(com.example.hellcat.pac1.model.BookItem.class);
        com.example.hellcat.pac1.model.BookItem object = null;
        while (objects.hasNext()) {
            object = (com.example.hellcat.pac1.model.BookItem) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Number realmGet$identificador = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$identificador();
            if (realmGet$identificador != null) {
                Table.nativeSetLong(tableNativePtr, columnInfo.identificadorIndex, rowIndex, realmGet$identificador.longValue(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.identificadorIndex, rowIndex, false);
            }
            String realmGet$titulo = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$titulo();
            if (realmGet$titulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.tituloIndex, rowIndex, realmGet$titulo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.tituloIndex, rowIndex, false);
            }
            String realmGet$autor = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$autor();
            if (realmGet$autor != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.autorIndex, rowIndex, realmGet$autor, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.autorIndex, rowIndex, false);
            }
            java.util.Date realmGet$fecha = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$fecha();
            if (realmGet$fecha != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.fechaIndex, rowIndex, realmGet$fecha.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fechaIndex, rowIndex, false);
            }
            String realmGet$descripcion = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$descripcion();
            if (realmGet$descripcion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descripcionIndex, rowIndex, false);
            }
            String realmGet$url = ((com_example_hellcat_pac1_model_BookItemRealmProxyInterface) object).realmGet$url();
            if (realmGet$url != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.urlIndex, rowIndex, realmGet$url, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.urlIndex, rowIndex, false);
            }
        }
    }

    public static com.example.hellcat.pac1.model.BookItem createDetachedCopy(com.example.hellcat.pac1.model.BookItem realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.hellcat.pac1.model.BookItem unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.example.hellcat.pac1.model.BookItem();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.hellcat.pac1.model.BookItem) cachedObject.object;
            }
            unmanagedObject = (com.example.hellcat.pac1.model.BookItem) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_example_hellcat_pac1_model_BookItemRealmProxyInterface unmanagedCopy = (com_example_hellcat_pac1_model_BookItemRealmProxyInterface) unmanagedObject;
        com_example_hellcat_pac1_model_BookItemRealmProxyInterface realmSource = (com_example_hellcat_pac1_model_BookItemRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$identificador(realmSource.realmGet$identificador());
        unmanagedCopy.realmSet$titulo(realmSource.realmGet$titulo());
        unmanagedCopy.realmSet$autor(realmSource.realmGet$autor());
        unmanagedCopy.realmSet$fecha(realmSource.realmGet$fecha());
        unmanagedCopy.realmSet$descripcion(realmSource.realmGet$descripcion());
        unmanagedCopy.realmSet$url(realmSource.realmGet$url());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("BookItem = proxy[");
        stringBuilder.append("{identificador:");
        stringBuilder.append(realmGet$identificador() != null ? realmGet$identificador() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{titulo:");
        stringBuilder.append(realmGet$titulo() != null ? realmGet$titulo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{autor:");
        stringBuilder.append(realmGet$autor() != null ? realmGet$autor() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha:");
        stringBuilder.append(realmGet$fecha() != null ? realmGet$fecha() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{descripcion:");
        stringBuilder.append(realmGet$descripcion() != null ? realmGet$descripcion() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{url:");
        stringBuilder.append(realmGet$url() != null ? realmGet$url() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_example_hellcat_pac1_model_BookItemRealmProxy aBookItem = (com_example_hellcat_pac1_model_BookItemRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBookItem.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBookItem.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBookItem.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
