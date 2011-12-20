(ns core.iteratee.process
  (:use [core.iteratee.types :only
          [continue continue? yield yield? eof eof?]]

        [core.iteratee.enumerators :only
          [produce-input-stream-bytes 
           produce-input-stream-lines]]))

(defn- get-proc-input-stream [cmd]
   (-> (Runtime/getRuntime)
       (.exec cmd)
       (.getInputStream)))

(defn produce-proc-bytes [cmd consumer]
  (produce-input-stream-bytes
      (get-proc-input-stream cmd) consumer))

(defn produce-proc-lines [cmd consumer]
  (produce-input-stream-lines
      (get-proc-input-stream cmd) consumer))

