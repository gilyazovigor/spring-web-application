/*
 * This file is generated by jOOQ.
 */
package org.jooq.sources;


import javax.annotation.Generated;

import org.jooq.Sequence;
import org.jooq.impl.SequenceImpl;


/**
 * Convenience access to all sequences in public
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Sequences {

    /**
     * The sequence <code>public.Organization_OrganizationID_seq</code>
     */
    public static final Sequence<Integer> ORGANIZATION_ORGANIZATIONID_SEQ = new SequenceImpl<Integer>("Organization_OrganizationID_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));

    /**
     * The sequence <code>public.Worker_WorkerID_seq</code>
     */
    public static final Sequence<Integer> WORKER_WORKERID_SEQ = new SequenceImpl<Integer>("Worker_WorkerID_seq", Public.PUBLIC, org.jooq.impl.SQLDataType.INTEGER.nullable(false));
}